package com.capgmn.harvest.repositories;

import com.capgmn.harvest.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

  List<Transaction> findById(long id);

}