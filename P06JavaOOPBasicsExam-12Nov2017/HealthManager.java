import models.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        if (!this.organisms.containsKey(organismName)) {
            return null;
        }
        return this.organisms.get(organismName).toString();
    }

    public String createOrganism(String name) {
        if (this.organisms.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        }
        Organism organism = new Organism(name);
        this.organisms.put(name, organism);
        return String.format("Created organism %s", name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (!this.organisms.containsKey(organismName)
                || this.organisms.get(organismName).getClusters().containsKey(id)) {
            return null;
        }
        Cluster cluster = new Cluster(id, rows, cols);
        this.organisms.get(organismName).addCluster(id, cluster);
        return String.format("Organism %s: Created cluster %s", organismName, id);
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        if (!this.organisms.containsKey(organismName)
                || !this.organisms.get(organismName).getClusters().containsKey(clusterId)
                || this.organisms.get(organismName).getClusters().get(clusterId).getRows() <= positionRow
                || this.organisms.get(organismName).getClusters().get(clusterId).getCols() <= positionCol) {
            return null;
        }
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
        this.organisms.get(organismName).getClusters().get(clusterId).addCell(cellId, cell);
        return String.format("Organism %s: Created cell %s in cluster %s",
                organismName, cellId, clusterId);
    }

    public String activateCluster(String organismName) {
        if (!this.organisms.containsKey(organismName)
                || this.organisms.get(organismName).getClusters().size() == 0) {
            return null;
        }

        Cluster clusterForActivation = this.organisms.get(organismName).getClusters().values()
                .iterator().next();

        List<Cell> sortedCells = clusterForActivation.getCells().values().stream()
                .sorted((c1, c2) -> {
                    if (Integer.compare(c1.getPositionRow(), c2.getPositionRow()) == 0) {
                        return Integer.compare(c1.getPositionCol(), c2.getPositionCol());
                    }
                    return Integer.compare(c1.getPositionRow(), c2.getPositionRow());
                })
                .collect(Collectors.toList());

        int index = 0;
        while (sortedCells.size() > 1) {
            if (sortedCells.get(index).getClass().getSimpleName().equals("RedBloodCell")
                    || sortedCells.get(index).getClass().getSimpleName().equals("WhiteBloodCell")) {
                sortedCells.get(index).increaseHealth(sortedCells.get(index + 1).getHealth());
                sortedCells.get(index).setPositionCol(sortedCells.get(index + 1).getPositionCol());
                sortedCells.get(index).setPositionRow(sortedCells.get(index + 1).getPositionRow());
                sortedCells.remove(index + 1);
            } else {
//                sortedCells.get(index).getHealth() > 0 & sortedCells.get(index + 1).getHealth() > 0
                while (true) {
                    sortedCells.get(index + 1).underAttack(sortedCells.get(index));
                    if (sortedCells.get(index + 1).getHealth() <= 0) {
                        sortedCells.get(index).setPositionCol(sortedCells.get(index + 1).getPositionCol());
                        sortedCells.get(index).setPositionRow(sortedCells.get(index + 1).getPositionRow());
                        sortedCells.remove(index + 1);
                        break;
                    }
                    sortedCells.get(index).underAttack(sortedCells.get(index + 1));
                    if (sortedCells.get(index).getHealth() <= 0) {
                        sortedCells.get(index + 1).setPositionCol(sortedCells.get(index).getPositionCol());
                        sortedCells.get(index + 1).setPositionRow(sortedCells.get(index).getPositionRow());
                        sortedCells.remove(index);
                        break;
                    }
                }
            }
        }
        if (sortedCells.size() == 1) {
            clusterForActivation.clearCells();
            clusterForActivation.addCell(sortedCells.get(0).getId(), sortedCells.get(0));
        }
        this.organisms.get(organismName).removeCluster(clusterForActivation.getId());
        this.organisms.get(organismName).addCluster(clusterForActivation.getId(), clusterForActivation);

        return String.format("Organism %s: Activated cluster %s. Cells left: %d",
                organismName, clusterForActivation.getId(), sortedCells.size());
    }
}
