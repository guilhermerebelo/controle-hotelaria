package ufsc.hotel.model.locacao;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class LocacaoService {

    private EntityManager em;

    public LocacaoService(EntityManager em) {
        this.em = em;
    }

    //donat
    public void taxaOcupacaoDosQuartos() {
        Query query = em.createQuery("select * from a");
//        List resultList = query.getResultList();
//        Object singleResult = query.getSingleResult();

        //retornar um mapa com descrição do quarto e total..
    }

    //donat
    public void produtosMaisConsumidos() {
        Query query = em.createQuery("select * from a");
//        List resultList = query.getResultList();
//        Object singleResult = query.getSingleResult();

        //retornar um mapa com o total de consumo no mes e a descrição do produto
    }

    //donat
    public void locacaoPorFuncionario() {
        Query query = em.createQuery("select * from a");
//        List resultList = query.getResultList();
//        Object singleResult = query.getSingleResult();

        //retornar um mapa com funcionario e quantidade..
    }


    //grafico em linha
    public void porcengagemOcupacaoHotel() {
        Query query = em.createQuery("select * from a");
//        List resultList = query.getResultList();
//        Object singleResult = query.getSingleResult();

        //porcentagem de ocupação dos ultimos 5 meses
    }

    //grafico em linha
    public void ticketMedioPorLocacao() {
        Query query = em.createQuery("select * from a");
//        List resultList = query.getResultList();
//        Object singleResult = query.getSingleResult();

        //ticket medio de locação dos ultimos 5 meses
    }
}
