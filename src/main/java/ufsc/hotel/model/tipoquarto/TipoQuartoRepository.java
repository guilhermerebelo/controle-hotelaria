package ufsc.hotel.model.tipoquarto;

import org.springframework.data.jpa.repository.JpaRepository;
import ufsc.hotel.model.hotel.Hotel;

public interface TipoQuartoRepository extends JpaRepository<Hotel, Long> {
}
