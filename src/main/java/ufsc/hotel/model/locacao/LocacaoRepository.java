package ufsc.hotel.model.locacao;

import org.springframework.data.jpa.repository.JpaRepository;
import ufsc.hotel.model.hotel.Hotel;

public interface LocacaoRepository extends JpaRepository<Hotel, Long> {
}
