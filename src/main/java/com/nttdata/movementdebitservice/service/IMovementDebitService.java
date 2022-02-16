package com.nttdata.movementdebitservice.service;

import com.nttdata.movementdebitservice.model.MovementDebit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementDebitService {
    Flux<MovementDebit> findAll();

    Mono<MovementDebit> findById(String id);

    Mono<MovementDebit> create(MovementDebit movementDebit);

    Mono<MovementDebit> update(String id, MovementDebit movementDebit);

    Mono<Void> delete(String id);
}
