package ufsc.hotel.model.funcionario;

import ufsc.hotel.model.hotel.Hotel;
import ufsc.hotel.model.pessoa.PessoaFisica;

import javax.persistence.*;

@Entity
@Table(name = "FUNCIONARIO")
@SequenceGenerator(name = "FUNCIONARIO_GENERATOR", sequenceName = "FUNCIONARIO_SEQ", allocationSize = 1)
public class Funcionario {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIONARIO_GENERATOR")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_PESSOA_FISICA")
    private PessoaFisica pessoaFisica;

    @ManyToOne
    @JoinColumn(name = "ID_HOTEL")
    private Hotel hotel;

}