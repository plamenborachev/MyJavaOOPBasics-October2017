package Controller;

import Models.Cluster;
import Models.Organism;
import Models.cells.Cell;
import Models.cells.bloodCells.RedBloodCell;
import Models.cells.bloodCells.WhiteBloodCell;
import Models.cells.microbes.Bacteria;
import Models.cells.microbes.Fungi;
import Models.cells.microbes.Virus;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new HashMap<>();
    }

    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return organisms.get(organismName).toString();
        } else {
            return null;
        }
    }

    public String createOrganism(String name) {
        if (organisms.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        } else {
            Organism organism = new Organism(name);
            organisms.put(name, organism);
            return String.format("Created organism %s", name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (organisms.containsKey(organismName)
                && !this.organisms.get(organismName).getClusters().containsKey(id)) {
            Cluster cluster = new Cluster(id, rows, cols);
            this.organisms.get(organismName).addCluster(cluster);
            return String.format("Organism %s: Created cluster %s", organismName, id);
        } else {
            return null;
        }
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int
            positionRow, int positionCol, int additionalProperty) {
        if (organisms.containsKey(organismName)
                && this.organisms.get(organismName).getClusters().containsKey(clusterId)
                && positionRow < this.organisms.get(organismName).getClusters().get(clusterId).getRows()
                && positionCol < this.organisms.get(organismName).getClusters().get(clusterId).getCols()) {
            Cell cell = null;
            switch (cellType) {
                case "RedBloodCell":
                    cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case "WhiteBloodCell":
                    cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case "Bacteria":
                    cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case "Fungi":
                    cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case "Virus":
                    cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
            }
            this.organisms.get(organismName).getClusters().get(clusterId).addCell(cell);
            return String.format("Organism %s: Created cell %s in cluster %s",
                    organismName, cellId, clusterId);
        } else {
            return null;
        }
    }

    public String activateCluster(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            String firstKey = this.organisms.get(organismName).getClusters().keySet().iterator().next();
            Cluster cluster = this.organisms.get(organismName).getClusters().get(firstKey);

            Cell[][] matrix = new Cell[cluster.getRows()][cluster.getCols()];

            for (Cell cell : cluster.getCells()) {
                matrix[cell.getPositionRow()][cell.getPositionCol()] = cell;
            }

            Cell battleCell = null;
            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix[rows].length; cols++) {
                    if (matrix[rows][cols] != null) {
                        battleCell = matrix[rows][cols];
                        break;
                    }
                }
            }

            Cell metCell = null;
            for (int rows = battleCell.getPositionRow(); rows < matrix.length; rows++) {
                for (int cols = battleCell.getPositionCol(); cols < matrix[rows].length; cols++) {
                    if (matrix[rows][cols] != null) {
                        metCell = matrix[rows][cols];

                    }
                }
            }



            return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, cluster.getClass().getSimpleName(), cluster.getCells().size());
        } else {
            return null;
        }
    }
}
