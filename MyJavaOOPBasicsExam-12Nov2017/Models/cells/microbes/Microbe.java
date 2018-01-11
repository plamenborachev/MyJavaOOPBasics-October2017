package Models.cells.microbes;

import Models.cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    protected Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        return String.format("%s%n--------Health: %d | Virulence: %d | Energy: %d",
                super.toString(), super.getHealth(), this.virulence, this.calculateEnergy());
    }
}
