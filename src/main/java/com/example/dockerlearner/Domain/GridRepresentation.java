package com.example.dockerlearner.Domain;

import java.util.ArrayList;
import java.util.List;

public class GridRepresentation {
    public List<List<Integer>> data;

    public GridRepresentation() {}

    public GridRepresentation(int[][] gridCells) {
        data = new ArrayList<>();
        int x = gridCells.length;    int y = gridCells[0].length;

        for(int i = 0; i < x; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < y; j++) {
                row.add(gridCells[i][j]);
            }
            data.add(row);
        }
    }
}
