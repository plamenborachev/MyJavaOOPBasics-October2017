package Models;

public class LightSoftwareComponent extends SoftwareComponent {
    public LightSoftwareComponent(String name, String type) {
        super(name, type);
    }

    @Override
    public void setCapacity(int capacity) {
        super.setCapacity(capacity * 3 / 2);
    }

    @Override
    public void setMemory(int memory) {
        super.setMemory(memory * 1 / 2);
    }
}
