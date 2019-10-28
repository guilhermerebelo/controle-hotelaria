package ufsc.hotel.model.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import ufsc.hotel.model.hotel.Hotel;

public interface PessoFisicaRepository extends JpaRepository<Hotel, Long> {
}
