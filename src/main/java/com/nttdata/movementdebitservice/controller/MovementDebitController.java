package com.nttdata.movementdebitservice.controller;


import com.nttdata.movementdebitservice.model.MovementDebit;
import com.nttdata.movementdebitservice.service.IMovementDebitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movementDebit")
public class MovementDebitController {

    private final IMovementDebitService service;

    @GetMapping
    public Flux<MovementDebit> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<MovementDebit> getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<MovementDebit> create(@RequestBody MovementDebit movementDebit) {
        return service.create(movementDebit);
    }

    @PutMapping("/{id}")
    public Mono<MovementDebit> update(@PathVariable String id, @RequestBody MovementDebit movementDebit) {
        return service.update(id, movementDebit);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
