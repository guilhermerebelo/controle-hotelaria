package ufsc.hotel.model.locacao;

import ufsc.hotel.model.funcionario.Funcionario;
import ufsc.hotel.model.hospede.Hospede;
import ufsc.hotel.model.notafiscal.NotaFiscal;
import ufsc.hotel.model.pessoa.PessoaFisica;
import ufsc.hotel.model.produto.Produto;
import ufsc.hotel.model.quarto.Quarto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOCACAO")
@SequenceGenerator(name = "LOCACAO_GENERATOR", sequenceName = "LOCACAO_SEQ", allocationSize = 1)
public class Locacao {

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
}