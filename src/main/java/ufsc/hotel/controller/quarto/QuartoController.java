package ufsc.hotel.controller.quarto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.quarto.Quarto;
import ufsc.hotel.model.quarto.QuartoRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("quarto")
public class QuartoController {

    private QuartoRepository repository;

    public QuartoController(QuartoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Quarto> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public Quarto find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Quarto save(@Valid @RequestBody Quarto entity) {
        return repository.save(entity);
    }

    @PutMapping("{id}")
    public Quarto put(@PathVariable(value = "id") Long id,
                       @Valid @RequestBody Quarto entity) {
        return repository.save(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
