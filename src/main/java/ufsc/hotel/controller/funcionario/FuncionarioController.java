package ufsc.hotel.controller.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.funcionario.Funcionario;
import ufsc.hotel.model.funcionario.FuncionarioRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("funcionario")
public class FuncionarioController {

    private FuncionarioRepository repository;

    public FuncionarioController(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Funcionario> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public Funcionario find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Funcionario save(@Valid @RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @PutMapping("{id}")
    public Funcionario put(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
