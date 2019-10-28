package ufsc.hotel.model.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import ufsc.hotel.model.hotel.Hotel;

public interface FuncionarioRepository extends JpaRepository<Hotel, Long> {
}
