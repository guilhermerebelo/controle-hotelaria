package ufsc.hotel.model.notafiscal;

import ufsc.hotel.model.locacao.Locacao;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "NOTA_FISCAL")
@SequenceGenerator(name = "NOTA_FISCAL_GENERATOR", sequenceName = "NOTA_FISCAL_SEQ", allocationSize = 1)
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTA_FISCAL_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_LOCACAO")
    private Locacao locacao;

    @Column(name = "DATA")
    LocalDate data;
}
