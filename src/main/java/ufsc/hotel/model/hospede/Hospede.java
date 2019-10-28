package ufsc.hotel.model.hospede;

import ufsc.hotel.model.pessoa.PessoaFisica;

import javax.persistence.*;

@Entity
@Table(name = "HOSPEDE")
@SequenceGenerator(name = "HOSPEDE_GENERATOR", sequenceName = "HOSPEDE_SEQ", allocationSize = 1)
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOSPEDE_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_PESSOA_FISICA", referencedColumnName = "id")
    private PessoaFisica pessoaFisica;
}
