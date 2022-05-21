package com.capgmn.harvest.repositories;

import com.capgmn.harvest.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
  Optional<List<Account>> findByCustomerId(String accountNumber);
}
