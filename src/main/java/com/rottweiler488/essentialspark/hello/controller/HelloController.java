package com.rottweiler488.essentialspark.hello.controller;

import com.rottweiler488.essentialspark.hello.dto.request.HelloRequest;
import com.rottweiler488.essentialspark.hello.dto.response.HelloResponse;
import com.rottweiler488.essentialspark.hello.service.HelloService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public HelloResponse helloGet(@RequestParam String message) {
        return helloService.processMessage(new HelloRequest(message));
    }

    @PostMapping
    public HelloResponse helloPost(@RequestBody HelloRequest request) {
        System.out.println(request.message());

        return helloService.processMessage(request);
    }
}