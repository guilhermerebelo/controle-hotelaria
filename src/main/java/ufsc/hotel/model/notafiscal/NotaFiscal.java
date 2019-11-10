package ufsc.hotel.model.notafiscal;

import ufsc.hotel.model.locacao.Locacao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "NOTA_FISCAL")
@SequenceGenerator(name = "NOTA_FISCAL_GENERATOR", sequenceName = "NOTA_FISCAL_SEQ", allocationSize = 1)
public class NotaFiscal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTA_FISCAL_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA")
    @NotNull(message = "Data é obrigatório")
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "ID_LOCACAO")
    @NotNull(message = "Locação é obrigatório")
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
