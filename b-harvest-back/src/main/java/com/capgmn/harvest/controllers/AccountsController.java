package com.capgmn.harvest.controllers;

import com.capgmn.harvest.dto.AccountInfoDTO;
import com.capgmn.harvest.entities.Account;
import com.capgmn.harvest.helpers.TransactionValidator;
import com.capgmn.harvest.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AccountsController {

  @Autowired
  private AccountService accountService;

  @GetMapping(value = "account/{cutomerId}")
  public ResponseEntity<?> getAccountInfo(@PathVariable("cutomerId") String cutomerId) {
    AccountInfoDTO accountInfo = accountService.getAccountInfo(cutomerId);
    if (accountInfo != null) {
      return new ResponseEntity<>(accountInfo, HttpStatus.OK);
    } else {
      return new ResponseEntity<>("There is no customer with this ID", HttpStatus.BAD_REQUEST);
    }
  }
}
