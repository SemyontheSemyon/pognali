package org.pognali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.pognali.models.Hello;
import org.pognali.repositories.HelloRepository;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("hello/get")
    List<Hello> getHellos() {

        return (List)helloRepository.findAll();

    }

    @PostMapping("hello/add")
    Hello addHello(@RequestBody Hello hello) {

        return helloRepository.save(hello);

    }

    @PostMapping("hello/{id}/update")
    Hello updateHello(@PathVariable Long helloId,
                      @RequestBody Hello helloRequest) {

        return helloRepository.findById(helloId)
                .map(hello -> {
                    hello.setText(helloRequest.getText());
                    return helloRepository.save(hello);
                }).orElseThrow(RuntimeException::new);

    }

    @DeleteMapping("hello/{id}/delete")
    ResponseEntity deleteHello(@PathVariable Long helloId) {

        return helloRepository.findById(helloId)
                .map(hello -> {
                    helloRepository.delete(hello);
                    return ResponseEntity.ok().build();
                }).orElseThrow(RuntimeException::new);

    }
}
