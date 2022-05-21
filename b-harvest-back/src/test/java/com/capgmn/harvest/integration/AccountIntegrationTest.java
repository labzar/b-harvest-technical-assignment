package com.capgmn.harvest.integration;

import com.capgmn.harvest.controllers.AccountsController;
import com.capgmn.harvest.dto.AccountInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "local")
public class AccountIntegrationTest {
  @Autowired
  private AccountsController accountsController;

  @Test
  void givenCustomerId_whenInitRequest_thenVerifyGetCustomerInfoisCompleteWithSuccess() {
    // given
    String customerID = "azerty1234";

    // when
    var accountInfoDTO = accountsController.getAccountInfo(customerID).getBody();

    // then
    var isComplete = (AccountInfoDTO) accountInfoDTO;
    assertThat(((AccountInfoDTO) accountInfoDTO).getCustomerId()).isEqualTo(customerID);
  }
}
