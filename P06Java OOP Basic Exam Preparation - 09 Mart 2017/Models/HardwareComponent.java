package Models;

public abstract class HardwareComponent extends Component {

    protected HardwareComponent(String name, String type) {
        super(name, type);
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent){

    }
}
