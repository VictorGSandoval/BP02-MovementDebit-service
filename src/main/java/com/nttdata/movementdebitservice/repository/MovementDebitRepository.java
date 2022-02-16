package com.nttdata.movementdebitservice.repository;

import com.nttdata.movementdebitservice.model.MovementDebit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MovementDebitRepository extends ReactiveCrudRepository<MovementDebit, String> {

}