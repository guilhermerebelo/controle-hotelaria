package ufsc.hotel.model.notafiscal;

import java.util.Date;

public final class NotaFiscalBuilder {
    private Long id;
    private Date data;

    private NotaFiscalBuilder() {
    }

    public static NotaFiscalBuilder create() {
        return new NotaFiscalBuilder();
    }

    public NotaFiscalBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public NotaFiscalBuilder data(Date data) {
        this.data = data;
        return this;
    }

    public NotaFiscal build() {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setId(id);
        notaFiscal.setData(data);
        return notaFiscal;
    }
}
