package ufsc.hotel.model.locacao;

import ufsc.hotel.model.funcionario.Funcionario;
import ufsc.hotel.model.hospede.Hospede;
import ufsc.hotel.model.pessoa.PessoaFisica;
import ufsc.hotel.model.produto.Produto;
import ufsc.hotel.model.quarto.Quarto;

import javax.persistence.*;
import java.time.LocalDate;
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
    @JoinColumn(name = "ID_QUARTO", referencedColumnName = "id")
    private Quarto quarto;

    @ManyToOne
    @JoinColumn(name = "ID_HOSPEDE", referencedColumnName = "id")
    private Hospede hospede;

    @ManyToOne
    @JoinColumn(name = "ID_PAGANTE", referencedColumnName = "id")
    private PessoaFisica pagante;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_INICIO_LOCACAO", referencedColumnName = "id")
    private Funcionario funcionarioInicioLocacao;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO_FINAL_LOCACAO", referencedColumnName = "id")
    private Hospede funcionarioFinalLocacao;

    @ManyToMany //ver a tabela intermediaria
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "id")
    private List<Produto> produtoConsumidos;
}