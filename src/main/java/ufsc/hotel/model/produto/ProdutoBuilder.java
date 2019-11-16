package ufsc.hotel.model.produto;

import java.math.BigDecimal;

public final class ProdutoBuilder
{
    private Long id;
    private String descricao;
    private BigDecimal valor;

    private ProdutoBuilder() {
    }

    public static ProdutoBuilder create() {
        return new ProdutoBuilder();
    }

    public ProdutoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProdutoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProdutoBuilder valor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Produto build() {
        Produto produto = new Produto();
        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setValor(valor);
        return produto;
    }
}
