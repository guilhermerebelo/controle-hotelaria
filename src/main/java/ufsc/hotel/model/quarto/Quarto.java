package ufsc.hotel.model.quarto;

import javax.persistence.*;

@Entity
@Table(name = "QUARTO")
@SequenceGenerator(name = "QUARTO_GENERATOR", sequenceName = "QUARTO_SEQ", allocationSize = 1)
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUARTO_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODIGO_QUARTO")
    private String codigo;

//    @ManyToOne
//    @JoinColumn(name = "ID_TIPO_QUARTO")
//    private TipoQuarto tiposQuarto;

}
