package ufsc.hotel.model.locacao;

import ufsc.hotel.model.funcionario.Funcionario;
import ufsc.hotel.model.hospede.Hospede;
import ufsc.hotel.model.notafiscal.NotaFiscal;
import ufsc.hotel.model.pessoa.PessoaFisica;
import ufsc.hotel.model.produto.Produto;
import ufsc.hotel.model.quarto.Quarto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOCACAO")
@SequenceGenerator(name = "LOCACAO_GENERATOR", sequenceName = "LOCACAO_SEQ", allocationSize = 1)
public class Locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCACAO_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_INICIAL")
    private LocalDate dataInicial;

    @Column(name = "DATA_FINAL")
    private LocalDate dataFinal;

    @ManyToOne
    @JoinColumn(name = "ID_QUARTO")
    private Quarto quarto;

    @ManyToOne
    @JoinColumn(name = "ID_HOSPEDE")
    private Hospede hospede;

    @ManyToOne
    @JoinColumn(name = "ID_PAGANTE")
    private PessoaFisica pagante;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_INICIO_LOCACAO")
    private Funcionario funcionarioIniciouLocacao;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_FINAL_LOCACAO")
    private Funcionario funcionarioFinalizouLocacao;

    @ManyToMany
    @JoinTable(
            name = "LOCACAO_PRODUTO",
            joinColumns = @JoinColumn(name = "ID_LOCACAO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO")
    )
    private List<Produto> produtoConsumidos = new ArrayList<>();

    @OneToOne(mappedBy = "locacao")
    private NotaFiscal notaFiscal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
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
}