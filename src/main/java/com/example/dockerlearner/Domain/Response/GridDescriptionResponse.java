package com.example.dockerlearner.Domain.Response;

import com.example.dockerlearner.Domain.Grid;
import com.example.dockerlearner.Domain.GridRepresentation;

import java.io.Serializable;
import java.util.List;

public class GridDescriptionResponse implements Serializable {

    public int id;
    public int x;
    public int y;
    public  List<List<Integer>> data;

    public GridDescriptionResponse() {}

    public GridDescriptionResponse(Grid grid) {
        this.id = grid.getId();
        this.x = grid.getX();
        this.y = grid.getY();

        GridRepresentation representation =   new GridRepresentation(grid.getGridCells());
        this.data = representation.data;
    }
}
