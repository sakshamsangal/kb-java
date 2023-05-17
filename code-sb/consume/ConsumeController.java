package com.example.consume;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.server.*;

/**
 * This is a controller class
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class ConsumeController {

    private final RestTemplate restTemplate;

    public void conPost() {
        log.info("conPost");

        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Bearer 623c0324-4395-3769-a8b9-49d3c8be91e9");

        // set the payload
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("title", "john");
        map.add("body", "body test");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        log.info(String.valueOf(entity));

        String catEndpoint = "https://jsonplaceholder.typicode.com/posts";

        try {
            ResponseEntity<String> response = restTemplate.exchange(catEndpoint, HttpMethod.POST, entity, String.class);
            log.info(String.valueOf(response));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public void conGet() {
        log.info("conGet");
        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Bearer 623c0324-4395-3769-a8b9-49d3c8be91e9");


        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);
        log.info(String.valueOf(entity));

        String catEndpoint = "https://jsonplaceholder.typicode.com/posts/2";

        ResponseEntity<String> response = restTemplate.exchange(catEndpoint, HttpMethod.GET, entity, String.class);
        log.info(String.valueOf(response));
    }


    @GetMapping("/con")
    ResponseEntity<String> con() {
        log.info("con");
        conGet();
        conPost();
        return ResponseEntity.ok().body("200");
    }


}