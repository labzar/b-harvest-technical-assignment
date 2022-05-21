package com.capgmn.harvest.helpers;

import com.capgmn.harvest.dto.TransactionDTO;

public class TransactionValidator {
  public static boolean isTransactionValid(TransactionDTO transactionDTO) {
    if (transactionDTO.getCustomerID().equals("")
            || transactionDTO.getCustomerID() == null
    ) {
      return false;
    }
    return true;
  }
}
