package ufsc.hotel.model.produto;

import javax.persistence.*;
import java.math.BigDecimal;

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
}
