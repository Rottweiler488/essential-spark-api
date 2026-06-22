package com.rottweiler488.essentialspark.hello.service;

import com.rottweiler488.essentialspark.hello.dto.request.HelloRequest;
import com.rottweiler488.essentialspark.hello.dto.response.HelloResponse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HelloService {
    private static final Set<String> GREETINGS = Set.of("hello", "hi", "hey", "welcome");
    private static final String DEFAULT_MESSAGE = "No, bye!";

    public HelloResponse processMessage(HelloRequest request) {
        String message = request.message();

        if (message == null) return new HelloResponse(DEFAULT_MESSAGE);

        String clearMessage = message.trim().toLowerCase();

        String result = GREETINGS.contains(clearMessage) ? "World!" : DEFAULT_MESSAGE;

        return new HelloResponse(result);
    }
}
