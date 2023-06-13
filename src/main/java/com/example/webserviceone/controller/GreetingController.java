package com.example.webserviceone.controller;

import com.example.webserviceone.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    // @GetMapping annotation ensures that HTTP GET requests sent to /greeting are mapped to the greeting() method.
   // Can also be written as   @RequestMapping(method = RequestMethod.GET, path = "/greeting")
   @GetMapping("/greeting")
   // @RequestParam annotation binds the value of the query string parameter name into the name parameter of the greeting() method.
   // If the name parameter is absent in the request, the defaultValue of World is used.
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
