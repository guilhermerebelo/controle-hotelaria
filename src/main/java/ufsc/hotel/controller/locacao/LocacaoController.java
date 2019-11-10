package ufsc.hotel.controller.locacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.locacao.Locacao;
import ufsc.hotel.model.locacao.LocacaoDto;
import ufsc.hotel.model.locacao.LocacaoRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@Transactional
@RequestMapping("locacao")
public class LocacaoController {

    private LocacaoRepository repository;

    public LocacaoController(LocacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Locacao> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public Locacao find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Locacao save(@Valid @RequestBody LocacaoDto entity) {
        List<Locacao> locacaoEmAndamento =
                repository.findLocacaoEmAndamento(entity.getDataInicial(), entity.getDataFinal(), entity.getQuarto());

        //TODO remover as validações das controllers
        if (!locacaoEmAndamento.isEmpty()) {
            throw new ValidationException("Já existe uma locação em andamento para esse quarto");
        }

        return repository.save(entity.create());
    }

    @PutMapping("{id}")
    public Locacao put(@PathVariable(value = "id") Long id, @Valid @RequestBody LocacaoDto entity) {
        List<Locacao> locacaoEmAndamento =
                repository.findLocacaoEmAndamento(entity.getDataInicial(), entity.getDataFinal(), entity.getQuarto());

        //TODO remover as validações das controllers
        if (!locacaoEmAndamento.isEmpty()) {
            throw new ValidationException("Já existe uma locação em andamento para esse quarto");
        }

        return repository.save(entity.create());
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
