package ufsc.hotel.model.hospede;

import ufsc.hotel.model.pessoa.PessoaFisica;

public final class HospedeBuilder {
    private Long id;
    private PessoaFisica pessoaFisica;

    private HospedeBuilder() {
    }

    public static HospedeBuilder create() {
        return new HospedeBuilder();
    }

    public HospedeBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public HospedeBuilder pessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
        return this;
    }

    public Hospede build() {
        Hospede hospede = new Hospede();
        hospede.setId(id);
        hospede.setPessoaFisica(pessoaFisica);
        return hospede;
    }
}
