package com.example.dockerlearner.Controller;

import com.example.dockerlearner.Domain.Request.AddOrModifyGridRequest;
import com.example.dockerlearner.Domain.Response.GridAgeWiseResponse;
import com.example.dockerlearner.Domain.Response.GridDescriptionResponse;
import com.example.dockerlearner.Service.GridService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/grids")
public class GridRest {

    @Inject
    GridService gridService;


    @RequestMapping(value = {""}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends Object> addGrid(@RequestBody AddOrModifyGridRequest request) {
        GridDescriptionResponse response = gridService.insertGrid(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends Object> modifyPatch(@PathVariable Integer id, @RequestBody AddOrModifyGridRequest request) {
        GridDescriptionResponse response = gridService.modifyGrid(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends Object> getGrid(@PathVariable Integer id) {
        GridDescriptionResponse response = gridService.getGrid(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}/after"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends Object> getGrid(@PathVariable Integer id, @RequestParam(value = "age", required = true) List<Integer> ageList) {
        GridAgeWiseResponse response = gridService.getGridInAgePhases(id, ageList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
