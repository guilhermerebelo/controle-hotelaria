package ufsc.hotel.model.tipoquarto;

import ufsc.hotel.model.produto.Produto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    @ManyToMany
    @JoinTable(
            name = "TIPO_QUARTO_PRODUTO",
            joinColumns = @JoinColumn(name = "ID_TIPO_QUARTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO")
    )
    private List<Produto> produtos = new ArrayList<>();
}
