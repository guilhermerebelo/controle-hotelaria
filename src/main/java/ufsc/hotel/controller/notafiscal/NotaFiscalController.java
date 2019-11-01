package ufsc.hotel.controller.notafiscal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.notafiscal.NotaFiscal;
import ufsc.hotel.model.notafiscal.NotaFiscalRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("nota-fiscal")
public class NotaFiscalController {

    private NotaFiscalRepository repository;

    public NotaFiscalController(NotaFiscalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<NotaFiscal> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public NotaFiscal find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public NotaFiscal save(@Valid @RequestBody NotaFiscal entity) {
        return repository.save(entity);
    }

    @PutMapping("{id}")
    public NotaFiscal put(@PathVariable(value = "id") Long id,
                          @Valid @RequestBody NotaFiscal entity) {
        return repository.save(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
