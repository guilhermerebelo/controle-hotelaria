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

    @Column(name = "DATA")
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "ID_LOCACAO")
    private Locacao locacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
}
