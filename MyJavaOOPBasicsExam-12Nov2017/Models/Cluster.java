package Models;

import Models.cells.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(cells);
    }

    public void addCell(Cell cell){
        this.cells.add(cell);
    }

    public void removeCell(Cell cell){
        this.cells.remove(cell);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----Cluster %s%n", this.id));
        List<Cell> sortedCells = this.cells.stream()
                .sorted(Comparator.comparingInt(Cell::getPositionRow).thenComparing(Cell::getPositionCol))
                .collect(Collectors.toList());
        for (Cell cell: sortedCells) {
            sb.append(cell);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
