package com.example.swagger;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.security.*;
import io.swagger.v3.oas.annotations.tags.*;
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
@Tag(name = "Tutorial", description = "Tutorial management APIs")
@SecurityRequirement(name = "javainuseapi")
public class PersonController {


    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status."
            // tags = { "tutorials", "get" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

    @GetMapping("/persons")
    ResponseEntity<String> getPersons() {
        log.info("getPersons");
        return new ResponseEntity<>("hello person", HttpStatus.OK);
    }




}