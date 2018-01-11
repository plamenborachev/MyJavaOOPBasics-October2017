package models;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    protected abstract int getEnergy();

    public int getHealth() {
        return this.health;
    }

    public String getId() {
        return this.id;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public void increaseHealth(int health){
        this.health += health;
    }

    public void underAttack(Cell attacker){
        this.health -= attacker.getEnergy();
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]",
                this.getId(), this.getPositionRow(), this.getPositionCol());
    }
}
