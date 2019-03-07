package org.pognali.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.pognali.Models.Hello;
import org.pognali.Repositories.HelloRepository;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("/")
    List<Hello> hello(){

        List<Hello> helloList = (List)helloRepository.findAll();
        String newHelloText = "Hello #" + (helloList.size()+1);
        helloRepository.save(new Hello(newHelloText));

        return (List)helloRepository.findAll();

    }

}
