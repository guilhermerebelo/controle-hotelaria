package ufsc.hotel.model.funcionario;

import ufsc.hotel.model.pessoa.PessoaFisica;

public final class FuncionarioBuilder {
    private Long id;
    private PessoaFisica pessoaFisica;

    private FuncionarioBuilder() {
    }

    public static FuncionarioBuilder create() {
        return new FuncionarioBuilder();
    }

    public FuncionarioBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public FuncionarioBuilder pessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
        return this;
    }

    public Funcionario build() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setPessoaFisica(pessoaFisica);
        return funcionario;
    }
}
