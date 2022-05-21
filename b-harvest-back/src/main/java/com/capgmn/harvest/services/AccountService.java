package com.capgmn.harvest.services;

import com.capgmn.harvest.dto.AccountInfoDTO;
import com.capgmn.harvest.entities.Account;
import com.capgmn.harvest.entities.Transaction;
import com.capgmn.harvest.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public AccountInfoDTO getAccountInfo(String customerID) {
    Optional<List<Account>> accountList = accountRepository.findByCustomerId(customerID);

    if (accountList.isPresent()) {
      List<Transaction> accountsTransactionList = accountList
              .get()
              .stream()
              .map(account -> account.getTransactions())
              .flatMap(List::stream)
              .collect(Collectors.toList());

      Account account = accountList.get().get(0);
      return  new AccountInfoDTO(
              account.getName(),
              account.getSurname(),
              account.getCustomerId(),
              accountsTransactionList
        );
    }

    return null;
  }
}
