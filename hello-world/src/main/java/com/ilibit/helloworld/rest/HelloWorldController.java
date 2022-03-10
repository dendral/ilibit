package com.ilibit.helloworld.rest;

import com.ilibit.helloworld.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello/world")
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping(path = "/insert-user")
    public String insertUser(@RequestBody User usuario){
        System.out.println("User: " + usuario);

        return "User inserted successfully";
    }

}
