package com.example.dockerlearner.Domain.Response;

import com.example.dockerlearner.Domain.Grid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GridResponse implements Serializable {

    int id;
    public int x;
    public int y;
    public List<List<Integer> > gridDescription;

    public GridResponse() {}

    public GridResponse(Grid grid) {
        this.id = grid.getId();
        this.x = grid.getX();
        this.y = grid.getY();

        gridDescription = new ArrayList<>();
        for(int i = 0; i < x; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < y; i++) {
                row.add(grid.getGridCells()[i][j]);
            }
            gridDescription.add(row);

        }
    }
}
