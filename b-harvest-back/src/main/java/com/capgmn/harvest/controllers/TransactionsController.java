package com.capgmn.harvest.controllers;

import com.capgmn.harvest.dto.TransactionDTO;
import com.capgmn.harvest.helpers.TransactionValidator;
import com.capgmn.harvest.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class TransactionsController {
  @Autowired
  private TransactionService transactionService;

  @PostMapping(value = "transaction",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> makeTransfer(
          @Valid @RequestBody TransactionDTO transactionDTO) {
    if (TransactionValidator.isTransactionValid(transactionDTO)) {
      boolean isOk = transactionService.makeTransfer(transactionDTO);
      return new ResponseEntity<>(isOk, HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Invalid Transaction", HttpStatus.BAD_REQUEST);
    }
  }
}
