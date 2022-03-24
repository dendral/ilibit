package com.ilibit.helloworld.rest;

import com.ilibit.helloworld.model.Transaction;
import com.ilibit.helloworld.model.TransactionFilter;
import com.ilibit.helloworld.model.TransactionResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    @GetMapping(path = "/api/v1/account/{accountId}/transactions")
    public TransactionResponse getTransactions(@PathVariable String accountId,
                                             @RequestParam String startDate,
                                             @RequestParam String endDate){
        TransactionResponse response = new TransactionResponse();
        response.setTransactions(loadTransactionsFromDB(accountId, startDate, endDate));
        return response;
    }

    @PostMapping(path = "/api/v1/account/transactions")
    public TransactionResponse getTransactions(@Valid @RequestBody TransactionFilter filter){
        TransactionResponse response = new TransactionResponse();

        response.setTransactions(loadTransactionsFromDB(filter.getAccount(), filter.getStartDate(), filter.getEndDate()));
        return response;
    }

    List<Transaction> loadTransactionsFromDB(String account, String ini, String end){
        List<Transaction> transactions = new ArrayList<>();
        Transaction one = new Transaction("11-01-2022", "20:59:00", 10.0, "Compra Amazon", "C");
        transactions.add(one);

        Transaction two = new Transaction();
        two.setAmount(3000.00);
        two.setDate("11-01-2022");
        two.setHour("20:22:13");
        two.setDescription("Transfer from paco's card");
        transactions.add(two);

        return transactions;
    }

}
