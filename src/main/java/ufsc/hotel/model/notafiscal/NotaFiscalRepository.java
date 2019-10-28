package ufsc.hotel.model.notafiscal;

import org.springframework.data.jpa.repository.JpaRepository;
import ufsc.hotel.model.hotel.Hotel;

public interface NotaFiscalRepository extends JpaRepository<Hotel, Long> {
}
