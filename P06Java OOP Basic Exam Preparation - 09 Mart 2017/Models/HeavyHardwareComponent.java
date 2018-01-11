package Models;

public class HeavyHardwareComponent extends HardwareComponent {
    public HeavyHardwareComponent(String name, String type) {
        super(name, type);
    }

    @Override
    public void setCapacity(int capacity) {
        super.setCapacity(capacity * 2);
    }

    @Override
    public void setMemory(int memory) {
        super.setMemory(memory * 75 / 100);
    }
}
