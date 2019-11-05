package ufsc.hotel.model.pessoa;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PESSOA_FISICA")
@SequenceGenerator(name = "PESSOA_FISICA_GENERATOR", sequenceName = "PESSOA_FISICA_SEQ", allocationSize = 1)
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_FISICA_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private Integer cpf;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

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

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
