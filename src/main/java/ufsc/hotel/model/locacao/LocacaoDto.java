package ufsc.hotel.model.locacao;

import ufsc.hotel.model.funcionario.Funcionario;
import ufsc.hotel.model.hospede.Hospede;
import ufsc.hotel.model.notafiscal.NotaFiscal;
import ufsc.hotel.model.pessoa.PessoaFisica;
import ufsc.hotel.model.produto.Produto;
import ufsc.hotel.model.quarto.Quarto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO criar uma validação com um DTO generic, utilizando algo com mapper do jackson
public class LocacaoDto {

    private Long id;
    private Date dataInicial;
    private Date dataFinal;
    private Quarto quarto;
    private Hospede hospede;
    private PessoaFisica pagante;
    private Funcionario funcionarioIniciouLocacao;
    private Funcionario funcionarioFinalizouLocacao;
    private List<Produto> produtoConsumidos = new ArrayList<>();
    private NotaFiscal notaFiscal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public PessoaFisica getPagante() {
        return pagante;
    }

    public void setPagante(PessoaFisica pagante) {
        this.pagante = pagante;
    }

    public Funcionario getFuncionarioIniciouLocacao() {
        return funcionarioIniciouLocacao;
    }

    public void setFuncionarioIniciouLocacao(Funcionario funcionarioIniciouLocacao) {
        this.funcionarioIniciouLocacao = funcionarioIniciouLocacao;
    }

    public Funcionario getFuncionarioFinalizouLocacao() {
        return funcionarioFinalizouLocacao;
    }

    public void setFuncionarioFinalizouLocacao(Funcionario funcionarioFinalizouLocacao) {
        this.funcionarioFinalizouLocacao = funcionarioFinalizouLocacao;
    }

    public List<Produto> getProdutoConsumidos() {
        return produtoConsumidos;
    }

    public void setProdutoConsumidos(List<Produto> produtoConsumidos) {
        this.produtoConsumidos = produtoConsumidos;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    //TODO implementar BUILDER para criar os objetos
    public Locacao create() {
        Locacao locacao = new Locacao();
        locacao.setDataInicial(dataInicial);
        locacao.setDataFinal(dataFinal);
        locacao.setQuarto(quarto);
        locacao.setHospede(hospede);
        locacao.setPagante(pagante);
        locacao.setFuncionarioIniciouLocacao(funcionarioIniciouLocacao);
        locacao.setFuncionarioFinalizouLocacao(funcionarioFinalizouLocacao);
        locacao.setProdutoConsumidos(produtoConsumidos);
        locacao.setNotaFiscal(notaFiscal);
        return locacao;
    }
}
