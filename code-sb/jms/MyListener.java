package com.example.demo.jms;

import org.springframework.jms.annotation.*;
import org.springframework.stereotype.*;

@Component
public class MyListener {

    @JmsListener(destination = "${spring.jms.myQueue}")
    public void myReceive(String message) {
        System.out.println("myReceive() " + message);
    }
}
