package ufsc.hotel.model.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import ufsc.hotel.model.hotel.Hotel;

public interface ProdutoRepository extends JpaRepository<Hotel, Long> {
}
