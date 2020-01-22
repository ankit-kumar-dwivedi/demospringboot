package com.example.demoapi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/Hello")
    public String sayHello(){
        return "Hello world [^_^]";
    }
}
