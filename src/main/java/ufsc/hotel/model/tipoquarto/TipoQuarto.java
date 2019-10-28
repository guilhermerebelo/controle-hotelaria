package ufsc.hotel.model.tipoquarto;

import ufsc.hotel.model.produto.Produto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "TIPO_QUARTO")
@SequenceGenerator(name = "TIPO_QUARTO_GENERATOR", sequenceName = "TIPO_QUARTO_SEQ", allocationSize = 1)
public class TipoQuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_QUARTO_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "VALOR")
    private BigDecimal diaria;

    @ManyToMany(mappedBy = "tiposQuarto")
    private List<Produto> produtos;
}
