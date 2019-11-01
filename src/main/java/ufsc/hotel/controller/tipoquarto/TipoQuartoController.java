package ufsc.hotel.controller.tipoquarto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.tipoquarto.TipoQuarto;
import ufsc.hotel.model.tipoquarto.TipoQuartoRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@Transactional
@RequestMapping("tipo-quarto")
public class TipoQuartoController {

    private TipoQuartoRepository repository;

    public TipoQuartoController(TipoQuartoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<TipoQuarto> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public TipoQuarto find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public TipoQuarto save(@Valid @RequestBody TipoQuarto entity) {
        return repository.save(entity);
    }

    @PutMapping("{id}")
    public TipoQuarto put(@PathVariable(value = "id") Long id,
                          @Valid @RequestBody TipoQuarto entity) {
        return repository.save(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
