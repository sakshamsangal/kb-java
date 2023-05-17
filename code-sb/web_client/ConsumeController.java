package com.example.web_client;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.*;

/**
 * This is a controller class
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class ConsumeController {

    // @Value("${endpoint.milk}")
    // private String milkEndpoint;


    @GetMapping("/con")
    ResponseEntity<String> con() {
        log.info("con");
        conGet();
        conPost();
        return ResponseEntity.ok().body("200");
    }

    private void conPost() {
        log.info("conPost");
        // String milkEndpoint = "https://jsonplaceholder.typicode.com/posts";
        //
        // WebClient webClient = WebClient.create();
        // String str = webClient.post()
        //         .uri(milkEndpoint)
        //         .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        //         .retrieve()
        //         .bodyToMono(String.class)
        //         .block();
        // log.info(str);

    }

    private void conGet() {
        log.info("conGet");
        String milkEndpoint = "https://jsonplaceholder.typicode.com/posts/2";

        WebClient webClient = WebClient.create();
        String str = webClient.get()
                .uri(milkEndpoint)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        log.info(str);
    }


}