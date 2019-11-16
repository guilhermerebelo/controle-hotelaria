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

public final class LocacaoBuilder {
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

    private LocacaoBuilder() {
    }

    public static LocacaoBuilder create() {
        return new LocacaoBuilder();
    }

    public LocacaoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public LocacaoBuilder dataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
        return this;
    }

    public LocacaoBuilder dataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
        return this;
    }

    public LocacaoBuilder quarto(Quarto quarto) {
        this.quarto = quarto;
        return this;
    }

    public LocacaoBuilder hospede(Hospede hospede) {
        this.hospede = hospede;
        return this;
    }

    public LocacaoBuilder pagante(PessoaFisica pagante) {
        this.pagante = pagante;
        return this;
    }

    public LocacaoBuilder funcionarioIniciouLocacao(Funcionario funcionarioIniciouLocacao) {
        this.funcionarioIniciouLocacao = funcionarioIniciouLocacao;
        return this;
    }

    public LocacaoBuilder funcionarioFinalizouLocacao(Funcionario funcionarioFinalizouLocacao) {
        this.funcionarioFinalizouLocacao = funcionarioFinalizouLocacao;
        return this;
    }

    public LocacaoBuilder produtoConsumidos(List<Produto> produtoConsumidos) {
        this.produtoConsumidos = produtoConsumidos;
        return this;
    }

    public LocacaoBuilder notaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
        return this;
    }

    public Locacao build() {
        Locacao locacao = new Locacao();
        locacao.setId(id);
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
