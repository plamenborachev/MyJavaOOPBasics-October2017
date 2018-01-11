package models;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
    }

    public void addCluster(String name, Cluster cluster){
        this.clusters.put(name, cluster);
    }

    public void removeCluster(String name){
        this.clusters.remove(name);
    }

    public Map<String, Cluster> getClusters() {
        return Collections.unmodifiableMap(this.clusters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s", this.name)).append(System.lineSeparator());
        sb.append(String.format("--Clusters: %d", this.clusters.size())).append(System.lineSeparator());
        sb.append(String.format("--Cells: %d", this.clusters.values().stream().mapToInt(cluster -> cluster
                .getCells().size()).sum())).append(System.lineSeparator());
        for (Cluster cluster : this.clusters.values()) {

            sb.append(cluster.toString()).append(System.lineSeparator());
            cluster.getCells().values().stream()
                    .sorted((c1, c2) -> {
                        if (Integer.compare(c1.getPositionRow(), c2.getPositionRow()) == 0) {
                            return Integer.compare(c1.getPositionCol(), c2.getPositionCol());
                        }
                        return Integer.compare(c1.getPositionRow(), c2.getPositionRow());
                    })
                    .forEach(cell -> sb.append(cell.toString()).append(System.lineSeparator()));
        }
        return sb.toString().trim();
    }
}
