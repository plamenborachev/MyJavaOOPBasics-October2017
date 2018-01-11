package Models.cells.bloodCells;

import Models.cells.Cell;

public abstract  class BloodCell extends Cell {
    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
