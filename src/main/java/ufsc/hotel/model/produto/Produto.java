package ufsc.hotel.model.produto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUTO")
@SequenceGenerator(name = "PRODUTO_GENERATOR", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DRSCRICAO", unique = true)
    @NotNull(message = "Descrição é obrigatório")
    private String descricao;

    @Column(name = "VALOR")
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
