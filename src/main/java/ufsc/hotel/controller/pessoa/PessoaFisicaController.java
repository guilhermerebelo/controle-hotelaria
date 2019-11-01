package ufsc.hotel.controller.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.pessoa.PessoaFisica;
import ufsc.hotel.model.pessoa.PessoaFisicaRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("pessoa-fisica")
public class PessoaFisicaController {

    private PessoaFisicaRepository repository;

    public PessoaFisicaController(PessoaFisicaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<PessoaFisica> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public PessoaFisica find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public PessoaFisica save(@Valid @RequestBody PessoaFisica entity) {
        return repository.save(entity);
    }

    @PutMapping("{id}")
    public PessoaFisica put(@PathVariable(value = "id") Long id,
                            @Valid @RequestBody PessoaFisica entity) {
        return repository.save(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
