package ufsc.hotel.model.tipoquarto;

import ufsc.hotel.model.produto.Produto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TIPO_QUARTO")
@SequenceGenerator(name = "TIPO_QUARTO_GENERATOR", sequenceName = "TIPO_QUARTO_SEQ", allocationSize = 1)
public class TipoQuarto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_QUARTO_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO", unique = true)
    @NotNull(message = "Descrição é obrigatório")
    private String descricao;

    @Column(name = "VALOR")
    @NotNull(message = "Diária é obrigatório")
    private BigDecimal diaria;

    @ManyToMany
    @JoinTable(
            name = "TIPO_QUARTO_PRODUTO",
            joinColumns = @JoinColumn(name = "ID_TIPO_QUARTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO")
    )
    private List<Produto> produtos = new ArrayList<>();

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

    public BigDecimal getDiaria() {
        return diaria;
    }

    public void setDiaria(BigDecimal diaria) {
        this.diaria = diaria;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
