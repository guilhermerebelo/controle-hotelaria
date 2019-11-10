package ufsc.hotel.model.hospede;

import ufsc.hotel.model.pessoa.PessoaFisica;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "HOSPEDE")
@SequenceGenerator(name = "HOSPEDE_GENERATOR", sequenceName = "HOSPEDE_SEQ", allocationSize = 1)
public class Hospede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOSPEDE_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_PESSOA_FISICA")
    @NotNull(message = "Pessoa física é obrigatório")
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
