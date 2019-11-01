package ufsc.hotel.controller.hospede;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.hospede.Hospede;
import ufsc.hotel.model.hospede.HospedeRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("hospede")
public class HospedeController {

    private HospedeRepository repository;

    public HospedeController(HospedeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Hospede> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public Hospede find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Hospede save(@Valid @RequestBody Hospede entity) {
        return repository.save(entity);
    }

    @PutMapping("{id}")
    public Hospede put(@PathVariable(value = "id") Long id,
                       @Valid @RequestBody Hospede entity) {
        return repository.save(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
