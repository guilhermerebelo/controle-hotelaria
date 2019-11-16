package ufsc.hotel.model.notafiscal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
