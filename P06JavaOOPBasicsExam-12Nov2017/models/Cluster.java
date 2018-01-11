package models;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Map<String, Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new LinkedHashMap<>();
    }

    public Map<String, Cell> getCells() {
        return Collections.unmodifiableMap(this.cells);
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

    public void addCell(String id, Cell cell){
        this.cells.put(id, cell);
    }

    public void clearCells(){
        this.cells.clear();
    }

    @Override
    public String toString() {
        return String.format("----Cluster %s", this.getId());
    }
}
