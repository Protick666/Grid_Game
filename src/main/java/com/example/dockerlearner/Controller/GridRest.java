package com.example.dockerlearner.Controller;

import com.example.dockerlearner.Domain.Request.AddOrModifyGridRequest;
import com.example.dockerlearner.Service.GridService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/grids")
public class GridRest {

    @Inject
    GridService gridService;


    @RequestMapping(value = {""}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addGrid(@RequestBody AddOrModifyGridRequest request) {
        gridService.insertGrid(request);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public void modifyPatch(@PathVariable Integer id, @RequestBody AddOrModifyGridRequest request) {
        gridService.modifyGrid(id, request);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void getGrid(@PathVariable Integer id) {
        gridService.getGrid(id);
    }

    @RequestMapping(value = {"/{id}/after"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void getGrid(@PathVariable Integer id, @RequestParam(value = "age", required = true) List<Integer> ageList) {
       // gridService.getGrid(id);
    }



}
