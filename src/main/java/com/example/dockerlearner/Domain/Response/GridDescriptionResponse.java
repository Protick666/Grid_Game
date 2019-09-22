package com.example.dockerlearner.Domain.Response;

import com.example.dockerlearner.Domain.Grid;
import com.example.dockerlearner.Domain.GridRepresentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GridDescriptionResponse implements Serializable {

    int id;
    public int x;
    public int y;
    public GridRepresentation data;

    public GridDescriptionResponse() {}

    public GridDescriptionResponse(Grid grid) {
        this.id = grid.getId();
        this.x = grid.getX();
        this.y = grid.getY();
        this.data = new GridRepresentation(grid.getGridCells());
    }
}
