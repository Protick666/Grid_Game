package com.example.dockerlearner.Service;

import com.example.dockerlearner.Domain.Grid;
import com.example.dockerlearner.Domain.Request.AddOrModifyGridRequest;
import com.example.dockerlearner.Domain.Response.GridAgeWiseResponse;
import com.example.dockerlearner.Domain.Response.GridDescriptionResponse;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GridService {
    private static int idCount = 1;

    Map<Integer, Grid> gridMap = new HashMap<>();

    private class NeighBourInfo {
        public int liveNeighbours;
        public int deadNeighbours;

        public NeighBourInfo() {}

        public NeighBourInfo(int liveNeighbours, int deadNeighbours) {
            this.liveNeighbours = liveNeighbours;
            this.deadNeighbours = deadNeighbours;
        }
    }

    public void populateSourceAndDestination(int[][] source, int[][] destination, Grid grid) {
        for(int i = 0; i < grid.getX(); i++) {
            for(int j = 0; j < grid.getY(); j++) {
                source[i][j] = grid.getGridCells()[i][j];
                destination[i][j] = grid.getGridCells()[i][j];
            }
        }
    }

    public GridDescriptionResponse insertGrid(AddOrModifyGridRequest request) {
        Grid grid = new Grid(idCount, request);
        gridMap.put(idCount, grid);
        idCount++;

        return new GridDescriptionResponse(grid);

    }

    public GridDescriptionResponse modifyGrid(int id, AddOrModifyGridRequest request) {
        Grid grid = new Grid(id, request);
        gridMap.put(id, grid);

        return new GridDescriptionResponse(grid);
    }

    public GridDescriptionResponse getGrid(int id) {
        return new GridDescriptionResponse(gridMap.get(id));
    }

    public GridAgeWiseResponse getGridInAgePhases(int id, List<Integer> ages) {
        Grid grid = gridMap.get(id);

        int X = grid.getX();    int Y = grid.getY();

        int[][] source = new int[X][Y];

        int[][] destination = new int[X][Y];

        populateSourceAndDestination(source, destination, grid);

        Collections.sort(ages);
        Map<Integer, Boolean> ageMap = new HashMap<>();
        for(int age : ages)
            ageMap.put(age, true);

        GridAgeWiseResponse response = new GridAgeWiseResponse(X, Y);
        if(ageMap.containsKey(0))
            response.insertGridStamp(0, grid.getGridCells());

        for(int i = 1; i <= ages.get(ages.size() - 1); i++) {
            for(int x  = 0; x < X; x++) {
                for(int y = 0; y < Y; y++) {

                    NeighBourInfo neighBourInfo =  getNeighboursInfo(x, y, source);
                    if(source[x][y] == 0) {
                        if(neighBourInfo.liveNeighbours == 3)
                            destination[x][y] = 1;
                        else
                            destination[x][y] = 0;
                    }
                    else {
                        if((neighBourInfo.liveNeighbours < 2) || (neighBourInfo.liveNeighbours > 3))
                            destination[x][y] = 0;
                        else
                            destination[x][y] = 1;

                    }
                }
            }

            if(ageMap.containsKey(i)) {
                response.insertGridStamp(i, destination);
            }
            int[][] temp = source;
            source = destination;
            destination = temp;
        }

        return response;
    }

    private NeighBourInfo getNeighboursInfo(int x, int y, int[][] grid) {
        int liveNBs = 0, deadNBs = 0;

        for(int xDir = -1; xDir <= 1; xDir++) {
            if((xDir + x ) < 0 || (xDir + x ) >= grid.length)
                continue;
            for(int yDir = -1; yDir <= 1; yDir++) {
                if(yDir == 0 && xDir == 0)
                    continue;
                if((yDir + y ) < 0 || (yDir + y ) >= grid[0].length)
                    continue;
                if(grid[x + xDir][y + yDir] == 1)
                    liveNBs++;
                else deadNBs++;
            }
        }

        return new NeighBourInfo(liveNBs, deadNBs);
    }

}
