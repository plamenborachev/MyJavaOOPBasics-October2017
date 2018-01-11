package models;

public abstract class Microbe extends Cell {

    private int virulence;

    protected Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    protected int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("--------Health: %d | Virulence: %d | Energy: %d",
                super.getHealth(), this.virulence, this.getEnergy()));
        return sb.toString();
    }
}
