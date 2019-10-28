package ufsc.hotel.model.hotel;

import ufsc.hotel.model.funcionario.Funcionario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HOTEL")
@SequenceGenerator(name = "HOTEL_GENERATOR", sequenceName = "HOTEL_SEQ", allocationSize = 1)
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @OneToMany
    @JoinColumn(name = "ID_HOTEL")
    private List<Funcionario> funcionarios = new ArrayList<>();
}
