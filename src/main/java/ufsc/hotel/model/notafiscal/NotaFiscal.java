package ufsc.hotel.model.notafiscal;

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

    @Column(name = "DATA")
    private LocalDate data;

//    @OneToOne
//    @JoinColumn(name = "ID_LOCACAO")
//    private Locacao locacao;

}
