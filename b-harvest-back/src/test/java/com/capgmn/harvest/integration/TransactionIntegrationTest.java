package com.capgmn.harvest.integration;

import com.capgmn.harvest.controllers.TransactionsController;
import com.capgmn.harvest.dto.TransactionDTO;
import com.capgmn.harvest.entities.Account;
import com.capgmn.harvest.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "local")
public class TransactionIntegrationTest {

  @Autowired
  private TransactionsController transactionsController;

  @Autowired
  private AccountRepository accountRepository;

  @Test
  void givenTransactionInfos_whenInitTransaction_thenVerifyTransactionisCompleteWithSuccess() {
    // givenTransactionInfos
    TransactionDTO transactionDTO = new TransactionDTO("azerty1234", 10);

    // whenInitTransaction
    var body = transactionsController.makeTransfer(transactionDTO).getBody();

    // thenVerifyTransactionisCompleteWithSuccess
    var isComplete = (Boolean) body;
    assertThat(isComplete).isTrue();
  }

  @Test
  void givenTransactionInfos_whenInitTransaction_thenVerifyNewAccountISCreatedAndAddedToCurrentCustomer() {
    // givenTransactionInfos
    String customerID = "azerty1234";
    double epsilon = 0.000001d;
    TransactionDTO transactionDTO = new TransactionDTO(customerID, 10);

    // whenInitTransaction
    var body = transactionsController.makeTransfer(transactionDTO).getBody();

    // thenVerifyNewAccountISCreatedAndAddedToCurrentCustomer
    var isComplete = (Boolean) body;
    assertThat(isComplete).isTrue();

    Optional<List<Account>> accounts = accountRepository.findByCustomerId(customerID);
    assertThat(accounts.get().size() > 2).isTrue();

    assertThat(accounts
            .get()
            .stream()
            .anyMatch(a -> a.getTransactions()
                    .stream()
                    .anyMatch(t-> Math.abs(t.getAmount() - 10) < epsilon)
            )
    ).isTrue();
  }
}
