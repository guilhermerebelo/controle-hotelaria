package ufsc.hotel.controller.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.produto.Produto;
import ufsc.hotel.model.produto.ProdutoRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("produto")
public class ProdutoController {

    private ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Produto> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public Produto find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Produto save(@Valid @RequestBody Produto entity) {
        return repository.save(entity);
    }

    @PutMapping("{id}")
    public Produto put(@PathVariable(value = "id") Long id,
                       @Valid @RequestBody Produto entity) {
        return repository.save(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
