package ufsc.hotel.model.produto;

import ufsc.hotel.model.tipoquarto.TipoQuarto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUTO")
@SequenceGenerator(name = "PRODUTO_GENERATOR", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DRSCRICAO")
    private String descricao;

    @Column(name = "VALOR")
    private BigDecimal valor;

    //TODO acho que esse relacionamento é um MANY TO MANY
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_QUARTO")

    @ManyToMany
    @JoinTable(
            name = "PRODUTO_TIPO_QUARTO",
            joinColumns = @JoinColumn(name = "ID_PRODUTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_TIPO_QUARTO")
    )
    private List<TipoQuarto> tiposQuarto;

    public Produto() {
    }
}
