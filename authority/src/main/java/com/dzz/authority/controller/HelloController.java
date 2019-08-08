package com.dzz.authority.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月07 21:17
 */
@RestController
@RequestMapping(
        value = {"/api/hello"},
        produces = MediaType.APPLICATION_JSON_VALUE
)
@Validated
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> greetings(@RequestParam("name") String name) {

        return ResponseEntity.ok("welcome " + name);
    }

}
