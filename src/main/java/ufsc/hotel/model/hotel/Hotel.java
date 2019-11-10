package ufsc.hotel.model.hotel;

import ufsc.hotel.model.funcionario.Funcionario;

import javax.persistence.*;
import java.io.Serializable;
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
    @JoinColumn(name = "HOTEL")
    private List<Funcionario> funcionarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
