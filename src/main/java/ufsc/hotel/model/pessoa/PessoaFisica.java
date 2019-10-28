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
}
