package com.example.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * This is a controller class
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class PersonController {
    private final PersonService personService;


    /*
    localhost:8080/jobs/importCustomers
     */

    @GetMapping("/persons")
    ResponseEntity<String> getPersons() {
        log.info("getPersons");

        // return ResponseEntity.ok()
        //         .header("Custom-Header", "foo")
        //         .body("Custom header set");


        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");
        return new ResponseEntity<>("hello person", headers, HttpStatus.OK);
    }



    @GetMapping("/persons/param")
    ResponseEntity<String> getPersons1(@RequestParam String id) {
        log.info("getPersons1");
        // return ResponseEntity.ok()
        //         .header("Custom-Header", "foo")
        //         .body("Custom header set");

        log.info("id = " + id);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");
        return new ResponseEntity<>("hello person", headers, HttpStatus.OK);
    }



}