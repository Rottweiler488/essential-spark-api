package com.rottweiler488.essentialspark;

import com.rottweiler488.essentialspark.hello.dto.request.HelloRequest;
import com.rottweiler488.essentialspark.hello.dto.response.HelloResponse;
import com.rottweiler488.essentialspark.hello.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    private final HelloService helloService = new HelloService();

    @ParameterizedTest
    @ValueSource(strings = {"hello", "hi", "hey", "welcome"})
    public void processMessage_shouldReturnWorld_whenMessageIsGreeting(String message) {
        HelloResponse response = helloService.processMessage(new HelloRequest(message));

        assertThat(response.message()).isEqualTo("World!");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello ", " Hi ", "   HEY", "  weLcoMe"})
    public void processMessage_shouldIgnoreCaseAndTrimSpace(String message) {
        HelloResponse response = helloService.processMessage(new HelloRequest(message));

        assertThat(response.message()).isEqualTo("World!");
    }

    @ParameterizedTest
    @ValueSource(strings = {"bye ", "", "World!!!  ", "He lo"})
    public void processMessage_shouldReturnDefaultMessage_whenMessageIsNotGreeting(String message) {
        HelloResponse response = helloService.processMessage(new HelloRequest(message));

        assertThat(response.message()).isEqualTo("No, bye!");
    }

    @Test
    public void processMessage_shouldReturnDefaultMessage_whenMessageIsNull() {
        HelloResponse response = helloService.processMessage(new HelloRequest(null));

        assertThat(response.message()).isEqualTo("No, bye!");
    }
}
