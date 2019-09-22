package com.example.dockerlearner.Controller;

import com.example.dockerlearner.Domain.Request.AddGridRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grids")
public class GridRest {

    @RequestMapping(value = {""}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addGrid(@RequestBody AddGridRequest topUpResponseTransfer) {
        return null;
    }

}
