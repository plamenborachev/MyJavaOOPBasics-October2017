package Models;

import Models.cells.Cell;

import java.util.*;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
    }

    public Map<String, Cluster> getClusters() {
        return Collections.unmodifiableMap(clusters);
    }

    public void addCluster(Cluster cluster) {
        this.clusters.put(cluster.getId(), cluster);
    }

    @Override
    public String toString() {
        int cellsCount = 0;
        for (Map.Entry<String, Cluster> cluster : this.clusters.entrySet()) {
            for (Cell cell : cluster.getValue().getCells()) {
                cellsCount++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s", this.name));
        sb.append(System.lineSeparator());
        sb.append(String.format("--Clusters: %d", this.clusters.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("--Cells: %d", cellsCount));
        sb.append(System.lineSeparator());
        for (Map.Entry<String, Cluster> cluster : this.clusters.entrySet()) {
            sb.append(cluster.getValue());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
