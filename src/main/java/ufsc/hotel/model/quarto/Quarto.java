package ufsc.hotel.model.quarto;

import ufsc.hotel.model.tipoquarto.TipoQuarto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "QUARTO")
@SequenceGenerator(name = "QUARTO_GENERATOR", sequenceName = "QUARTO_SEQ", allocationSize = 1)
public class Quarto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUARTO_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODIGO_QUARTO", unique = true)
    @NotNull(message = "Código é obrigatório")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_QUARTO")
    @NotNull(message = "Tipo do quarto é obrigatório")
    private TipoQuarto tipoQuarto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
}
