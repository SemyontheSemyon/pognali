package pognali.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pognali.Models.Hello;
import pognali.Repositories.HelloRepository;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("/")
    List<Hello> hello(){

        List<Hello> helloList = (List)helloRepository.findAll();
        String newHelloText = "Hello #" + (helloList.size()+1);
        Hello newHello = new Hello(newHelloText);
        helloRepository.save(newHello);

        return (List)helloRepository.findAll();

    }

}
