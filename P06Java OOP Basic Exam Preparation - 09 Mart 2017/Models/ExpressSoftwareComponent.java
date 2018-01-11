package Models;

public class ExpressSoftwareComponent extends SoftwareComponent {
    public ExpressSoftwareComponent(String name, String type) {
        super(name, type);
    }

    @Override
    public void setMemory(int memory) {
        super.setMemory(memory * 2);
    }
}
