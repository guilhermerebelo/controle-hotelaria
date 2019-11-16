package ufsc.hotel.model.quarto;

import ufsc.hotel.model.tipoquarto.TipoQuarto;

public final class QuartoBuilder {
    private Long id;
    private String codigo;
    private TipoQuarto tipoQuarto;

    private QuartoBuilder() {
    }

    public static QuartoBuilder create() {
        return new QuartoBuilder();
    }

    public QuartoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public QuartoBuilder codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public QuartoBuilder tipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
        return this;
    }

    public Quarto build() {
        Quarto quarto = new Quarto();
        quarto.setId(id);
        quarto.setCodigo(codigo);
        quarto.setTipoQuarto(tipoQuarto);
        return quarto;
    }
}
