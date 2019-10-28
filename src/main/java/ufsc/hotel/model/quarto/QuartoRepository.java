package ufsc.hotel.model.quarto;

import org.springframework.data.jpa.repository.JpaRepository;
import ufsc.hotel.model.hotel.Hotel;

public interface QuartoRepository extends JpaRepository<Hotel, Long> {
}
