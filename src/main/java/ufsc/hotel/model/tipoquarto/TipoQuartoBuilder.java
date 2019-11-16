package ufsc.hotel.model.tipoquarto;

import ufsc.hotel.model.produto.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class TipoQuartoBuilder {
    private Long id;
    private String descricao;
    private BigDecimal diaria;
    private List<Produto> produtos = new ArrayList<>();

    private TipoQuartoBuilder() {
    }

    public static TipoQuartoBuilder create() {
        return new TipoQuartoBuilder();
    }

    public TipoQuartoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public TipoQuartoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public TipoQuartoBuilder diaria(BigDecimal diaria) {
        this.diaria = diaria;
        return this;
    }

    public TipoQuartoBuilder produtos(List<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public TipoQuarto build() {
        TipoQuarto tipoQuarto = new TipoQuarto();
        tipoQuarto.setId(id);
        tipoQuarto.setDescricao(descricao);
        tipoQuarto.setDiaria(diaria);
        tipoQuarto.setProdutos(produtos);
        return tipoQuarto;
    }
}
