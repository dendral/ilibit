package com.ilibit.helloworld.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

    @GetMapping("/transaction-filter")
    public String showForm() {
        return "transaction_filter";
    }

    @GetMapping("/transaction-filter-post")
    public String showFormPost() {
        return "transaction_filter_post";
    }

}
