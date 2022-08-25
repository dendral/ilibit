package com.ilibit.helloworld.service;

import com.ilibit.helloworld.model.Transaction;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
This class contains the BUSINESS LOGIC to fetch the account transactions
 */
@Service
public class TransactionService {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    /**
     * This menthod checks that the account exists and that startDate <= endDate
     * @param account
     * @param startDate
     * @param endDate
     * @return
     */
   public List<Transaction> fetchTransactions(String account, String startDate, String endDate){
        List<Transaction> transactions = new ArrayList<>();
        //22-10-1987
        LocalDate iniDate = LocalDate.parse(startDate, dtf);
        LocalDate endDate1 = LocalDate.parse(endDate, dtf);

        if(iniDate.isAfter(endDate1)){
            throw new RuntimeException("Start date cannon be greater than End date");
        }
        Transaction one = new Transaction("11-01-2022", "20:59:00", 10.1, "Compra Amazon", "C");
        transactions.add(one);

        Transaction two = new Transaction();
        two.setAmount(3000.0);
        two.setDate("11-01-2022");
        two.setHour("20.22.13");
        two.setDescription("Transfer from paco");
        two.setType("D");
        transactions.add(two);
        Transaction three = new Transaction("12-01-2022", "20:59:00", 10.1, "Compra Javier", "C");
        transactions.add(three);

        //if(iniDate.isBefore(endDate1) || iniDate.isEqual(endDate1)){
            //ir a BD
       // } else{
            //mandar un error
       // }


        return transactions;

    }
}

