package ufsc.hotel.model.locacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ufsc.hotel.model.quarto.Quarto;

import java.util.Date;
import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    @Query("select l from Locacao l where not ((l.dataInicial > :dataFinal or l.dataFinal < :dataInicial) and (l.quarto = :quarto))")
    List<Locacao> findLocacaoEmAndamento(@Param("dataInicial") Date dataInicial,
                                         @Param("dataFinal") Date dataFinal,
                                         @Param("quarto") Quarto quarto);
}
