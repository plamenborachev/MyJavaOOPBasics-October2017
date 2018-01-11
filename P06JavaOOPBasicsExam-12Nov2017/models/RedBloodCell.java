package models;

public class RedBloodCell extends BloodCell {

    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("--------Health: %d | Velocity: %d | Energy: %d",
                super.getHealth(), this.velocity, this.getEnergy()));
        return sb.toString();
    }
}
