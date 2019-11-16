package ufsc.hotel.model.notafiscal;

import ufsc.hotel.model.locacao.Locacao;

import java.time.LocalDate;

public final class NotaFiscalBuilder {
    private Long id;
    private LocalDate data;
    private Locacao locacao;

    private NotaFiscalBuilder() {
    }

    public static NotaFiscalBuilder create() {
        return new NotaFiscalBuilder();
    }

    public NotaFiscalBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public NotaFiscalBuilder data(LocalDate data) {
        this.data = data;
        return this;
    }

    public NotaFiscalBuilder locacao(Locacao locacao) {
        this.locacao = locacao;
        return this;
    }

    public NotaFiscal build() {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setId(id);
        notaFiscal.setData(data);
        notaFiscal.setLocacao(locacao);
        return notaFiscal;
    }
}
