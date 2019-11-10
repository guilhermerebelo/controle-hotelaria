package ufsc.hotel.model.pessoa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "PESSOA_FISICA")
@SequenceGenerator(name = "PESSOA_FISICA_GENERATOR", sequenceName = "PESSOA_FISICA_SEQ", allocationSize = 1)
public class PessoaFisica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_FISICA_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Column(name = "CPF", unique = true)
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
