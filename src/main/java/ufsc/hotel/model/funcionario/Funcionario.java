package ufsc.hotel.model.funcionario;

import ufsc.hotel.model.pessoa.PessoaFisica;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FUNCIONARIO")
@SequenceGenerator(name = "FUNCIONARIO_GENERATOR", sequenceName = "FUNCIONARIO_SEQ", allocationSize = 1)
public class Funcionario implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIONARIO_GENERATOR")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_PESSOA_FISICA")
    private PessoaFisica pessoaFisica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}