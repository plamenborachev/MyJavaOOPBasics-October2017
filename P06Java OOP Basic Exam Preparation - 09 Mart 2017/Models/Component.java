package Models;

public abstract class Component {
    private String name;
    private String type;
    private int capacity;
    private int memory;

    protected Component(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getMemory() {
        return this.memory;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}

