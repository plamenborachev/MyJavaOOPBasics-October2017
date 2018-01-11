package Models;

public class PowerHardwareComponent extends HardwareComponent {
    public PowerHardwareComponent(String name, String type) {
        super(name, type);
    }

    @Override
    public void setCapacity(int capacity) {
        super.setCapacity(capacity * 1 / 4);
    }

    @Override
    public void setMemory(int memory) {
        super.setMemory(memory * 7 / 4);
    }
}
