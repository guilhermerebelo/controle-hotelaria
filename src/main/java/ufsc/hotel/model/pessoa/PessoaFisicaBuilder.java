package ufsc.hotel.model.pessoa;

import java.util.Date;

public final class PessoaFisicaBuilder {
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;

    private PessoaFisicaBuilder() {
    }

    public static PessoaFisicaBuilder create() {
        return new PessoaFisicaBuilder();
    }

    public PessoaFisicaBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PessoaFisicaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaFisicaBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public PessoaFisicaBuilder dataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public PessoaFisica build() {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setId(id);
        pessoaFisica.setNome(nome);
        pessoaFisica.setCpf(cpf);
        pessoaFisica.setDataNascimento(dataNascimento);
        return pessoaFisica;
    }
}
