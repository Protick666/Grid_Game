package com.example.dockerlearner.Service;

import com.example.dockerlearner.Domain.Grid;
import com.example.dockerlearner.Domain.Request.AddOrModifyGridRequest;
import com.example.dockerlearner.Domain.Response.GridResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GridService {
    private static int idCount = 1;

    Map<Integer, Grid> gridMap = new HashMap<>();

    public int insertGrid(AddOrModifyGridRequest request) {
        Grid grid = new Grid(idCount, request);
        gridMap.put(idCount, grid);
        idCount++;

        return grid.getId();

    }

    public void modifyGrid(int id, AddOrModifyGridRequest request) {
        Grid grid = new Grid(id, request);
        gridMap.put(id, grid);
    }

    public GridResponse getGrid(int id) {
        return new GridResponse(gridMap.get(id));
    }


}
