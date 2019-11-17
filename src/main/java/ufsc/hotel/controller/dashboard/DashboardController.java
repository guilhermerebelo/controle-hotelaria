package ufsc.hotel.controller.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("dashboard")
public class DashboardController {

    private final EntityManager em;

    public DashboardController(EntityManager em) {
        this.em = em;
    }

    @GetMapping("melhores-clientes")
    public List melhoresClientes() {
        Query query = em.createNativeQuery(
                "select count(c1.cpf) as total, c1.nome as nome from " +
                        "(select p.cpf, p.nome from locacao as l " +
                        "inner join hospede as h " +
                        "on l.id_hospede = h.id " +
                        "inner join pessoa_fisica as p " +
                        "on h.id_pessoa_fisica = p.id) as c1 " +
                        "group by nome " +
                        "order by total desc, nome " +
                        "limit 7");

        return query.getResultList();
    }

    @GetMapping("total-hospedes-ano")
    public List totalHospedesAno() {
        Query query = em.createNativeQuery(
                "select count(*), consultaAno.ano from (select date_part('year', CAST(l.data_inicial AS DATE)) as ano, p.nome, p.cpf " +
                        "from locacao as l " +
                        "inner join hospede as h " +
                        "on l.id_hospede = h.id " +
                        "inner join pessoa_fisica as p " +
                        "on h.id_pessoa_fisica = p.id) as consultaAno " +
                        "group by ano " +
                        "order by ano asc");

        return query.getResultList();
    }

    @GetMapping("funcionario-mais-locacoes-mes")
    public List funcionarioMaisLocacoesMes() {
        Query query = em.createNativeQuery(
                "select count(r.mes) as total, nome, mes from " +
                        "(select to_char(l.data_inicial, 'MM/YYYY') as mes, p.nome, p.cpf from locacao as l  " +
                        "inner join funcionario as f on l.id_funcionario_inicio_locacao = f.id " +
                        "inner join pessoa_fisica as p on f.id_pessoa_fisica = p.id " +
                        "where to_char(l.data_inicial, 'MM/YYYY') = to_char((now()), 'MM/YYYY')) as r " +
                        "group by mes, nome " +
                        "order by total");

        return query.getResultList();
    }

    @GetMapping("faturamento-produto-mes")
    public List faturamentoProdutoMes() {
        Query query = em.createNativeQuery(
                "select busca.drscricao, count(busca.valor) as total, sum(busca.valor) as valor from " +
                        "(select * from locacao_produto as lp inner join " +
                        "produto as pro on " +
                        "pro.id = lp.produto " +
                        "where lp.locacao in " +
                        "(select id from locacao as l where to_char(l.data_inicial, 'MM/YYYY') = to_char((now() - interval '0 month'), 'MM/YYYY'))) as busca " +
                        "group by drscricao " +
                        "order by valor desc");

        return query.getResultList();
    }

    @GetMapping("faturamento-anual-quartos")
    public List faturamentoAnualQuartos() {
        Query query = em.createNativeQuery(
                "select sum(c_ano.valor) as faturamento from " +
                        "(select * from locacao as l  " +
                        "inner join quarto as q  " +
                        "on l.id_quarto = q.id_tipo_quarto " +
                        "inner join tipo_quarto as tq " +
                        "on q.id_tipo_quarto = tq.id " +
                        "where date_part('year', CAST(l.data_inicial AS DATE)) = '2019') as c_ano");

        return query.getResultList();
    }

    @GetMapping("faturamento-ultimos-doze-meses")
    public List faturamnetoUltimosDozeMeses() {
        Query query = em.createNativeQuery(
                "select sum(f_total.valor) from " +
                        "(select sum(c1.valor) as valor from  " +
                        "(select * from locacao_produto as lp inner join produto as pro on pro.id = lp.produto " +
                        "where lp.locacao in (select id from locacao as l where date_part('year', CAST(l.data_inicial AS DATE)) = '2019')) as c1  " +
                        "union " +
                        "select sum(c2.valor) as faturamento from " +
                        "(select * from locacao as l inner join quarto as q on l.id_quarto = q.id_tipo_quarto inner join tipo_quarto as tq on q.id_tipo_quarto = tq.id " +
                        "where date_part('year', CAST(l.data_inicial AS DATE)) = '2019') as c2) as f_total");

        return query.getResultList();
    }

    @GetMapping("faturamento-anual-categoria-quarto")
    public List faturamentoAnualCategoriaQuarto() {
        Query query = em.createNativeQuery(
                "select sum(c1.valor) as valorTotal, count(c1.descricao) as quantidade, descricao from " +
                        "(select tp.descricao, tp.valor from locacao as l  " +
                        "inner join quarto as q  " +
                        "on l.id_quarto = q.id  " +
                        "inner join tipo_quarto as tp  " +
                        "on q.id_tipo_quarto = tp.id " +
                        "where date_part('year', CAST(l.data_inicial AS DATE)) = '2019') as c1 " +
                        "group by descricao " +
                        "order by valorTotal desc");

        return query.getResultList();
    }
}
