package ufsc.hotel.controller.hotel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufsc.hotel.model.hotel.Hotel;
import ufsc.hotel.model.hotel.HotelRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@RequestMapping("hotel")
public class HotelController {

    private HotelRepository repository;

    public HotelController(HotelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Hotel> findAll() {
        return repository.findAll(PageRequest.of(0, 20));
    }

    @GetMapping("{id}")
    public Hotel find(@PathVariable(value = "id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Hotel save(@Valid @RequestBody Hotel entity) {
        return repository.save(entity);
    }

    @PutMapping("{id}")
    public Hotel put(@PathVariable(value = "id") Long id,
                     @Valid @RequestBody Hotel entity) {
        return repository.save(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable(value = "id") Long id) {
        repository.delete(repository.findById(id).get());
        return ResponseEntity.noContent().build();
    }
}
