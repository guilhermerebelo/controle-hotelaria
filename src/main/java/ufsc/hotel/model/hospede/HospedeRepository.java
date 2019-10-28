package ufsc.hotel.model.hospede;

import org.springframework.data.jpa.repository.JpaRepository;
import ufsc.hotel.model.hotel.Hotel;

public interface HospedeRepository extends JpaRepository<Hotel, Long> {
}
