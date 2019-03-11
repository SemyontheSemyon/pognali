package org.pognali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.pognali.models.Hello;
import org.pognali.repositories.HelloRepository;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("/get")
    List<Hello> getHellos(){

        return (List)helloRepository.findAll();

    }

    @PostMapping("/post")
    Hello postHello(@RequestBody Hello hello){

        return helloRepository.save(hello);

    }
}
