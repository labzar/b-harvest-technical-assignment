package com.capgmn.harvest.services;

import com.capgmn.harvest.dto.TransactionDTO;
import com.capgmn.harvest.entities.Account;
import com.capgmn.harvest.entities.Transaction;
import com.capgmn.harvest.repositories.AccountRepository;
import com.capgmn.harvest.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {
  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private TransactionRepository transactionRepository;

  public boolean makeTransfer(TransactionDTO transactionDTO) {
    Optional<List<Account>> accountList = accountRepository.findByCustomerId(transactionDTO.getCustomerID());
    if (accountList.isPresent() &&
            accountList.get().size() > 0
    ) {
      Account currentAccount = accountList.get().get(0);
      Account newAccount = new Account(
              currentAccount.getName(),
              currentAccount.getSurname(),
              transactionDTO.getInitialCredit(),
              currentAccount.getCustomerId(),
              UUID.randomUUID().toString());

      if (transactionDTO.getInitialCredit() > 0) {
        Transaction transaction = new Transaction(transactionDTO.getInitialCredit(), newAccount);
        newAccount.setTransactions(Arrays.asList(transaction));
      }

      accountRepository.save(newAccount);

      return true;
    }
    return false;
  }
}
