package com.capgmn.harvest.unit;

import com.capgmn.harvest.dto.AccountInfoDTO;
import com.capgmn.harvest.entities.Account;
import com.capgmn.harvest.repositories.AccountRepository;
import com.capgmn.harvest.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AccountServiceTest {

  @TestConfiguration
  static class AccountServiceTestContextConfiguration {

    @Bean
    public AccountService accountService() {
      return new AccountService();
    }
  }

  @Autowired
  private AccountService accountService;

  @MockBean
  private AccountRepository accountRepository;

  @BeforeEach
  void setUp() {
    var account = new Account(
            "TATA",
            "TOTO",
            100,
            "azerty-azerty",
            "123456789",
            Collections.emptyList()
    );

    when(accountRepository.findByCustomerId("azerty-azerty"))
            .thenReturn(Optional.of(Arrays.asList(account)));
  }

  @Test
  void whenAccountDetails_thenAccountShouldBeFound() {
    AccountInfoDTO account = accountService.getAccountInfo("azerty-azerty");
    assertThat(account.getName()).isEqualTo("TATA");
    assertThat(account.getSurname()).isEqualTo("TOTO");
    assertThat(account.getCustomerId()).isEqualTo("azerty-azerty");
  }

}
