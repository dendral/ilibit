package com.ilibit.helloworld.rest;
//package com.fji.hellofam.controllers;

import com.ilibit.helloworld.service.TransactionService;
import com.ilibit.helloworld.model.Transaction;
import com.ilibit.helloworld.model.TransactionFilter;
import com.ilibit.helloworld.model.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {
	//field injection
	//@Autowired
    TransactionService transactionService;
   
   
    //constructor injection
	//    public TransactionController(TransactionService ts){
	//        transactionService = ts;
	//    }

    //Setter injection
   @Autowired
	public void setTransactionService(TransactionService ts) {
		this.transactionService = ts;
	}

   @GetMapping(path = "/api/v1/account/{accountId}/transactions")
   public TransactionResponse getTransactions(@PathVariable String accountId,
                                            @RequestParam String startDate,
                                            @RequestParam String endDate){
       TransactionResponse response = new TransactionResponse();
       response.setTransactions(transactionService.fetchTransactions(accountId, startDate, endDate));
       return response;
   }

   @PostMapping(path = "/api/v1/account/transactions" )
   public  TransactionResponse getTransactions(@Valid  @RequestBody TransactionFilter filter){
   TransactionResponse response = new TransactionResponse();
   response.setTransactions(transactionService.fetchTransactions(filter.getAccount(), filter.getStartDate(), filter.getEndDate()));
   return response;
   }
   
}

//Controller - REST/API/Endpoint definition
//Service - Business logic
//Repository - BD