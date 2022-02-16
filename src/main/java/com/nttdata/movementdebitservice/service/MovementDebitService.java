package com.nttdata.movementdebitservice.service;

import com.nttdata.movementdebitservice.model.MovementDebit;
import com.nttdata.movementdebitservice.repository.MovementDebitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MovementDebitService implements IMovementDebitService {
    private final MovementDebitRepository repository;

    @Override
    public Flux<MovementDebit> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<MovementDebit> findById(String id) {
        return  repository.findById(id);
    } 

    @Override
    public Mono<MovementDebit> create(MovementDebit movementDebit) {
        movementDebit.setDate(LocalDate.now());
        return repository.save(movementDebit);
    }

    @Override
    public Mono<MovementDebit> update(String id, MovementDebit movementDebit) {
        return repository.findById(id).flatMap(newMovementDebit -> {
            movementDebit.setId(newMovementDebit.getId());
            return repository.save(movementDebit);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id).flatMap(movementDebit -> repository.deleteById(movementDebit.getId()));
    }
}
