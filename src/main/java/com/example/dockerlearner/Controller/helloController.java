package com.example.dockerlearner.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docker")
public class helloController {

    @RequestMapping(value = {""}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String validate() {
        return "hello world";
    }
}
