package com.rottweiler488.essentialspark.hello.controller;

import com.rottweiler488.essentialspark.hello.dto.request.HelloRequest;
import com.rottweiler488.essentialspark.hello.dto.response.HelloResponse;
import com.rottweiler488.essentialspark.hello.service.HelloService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
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