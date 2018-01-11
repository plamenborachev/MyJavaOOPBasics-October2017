package p07CarSalesman;

public class Engine {
    private String engineModel;
    private  int power;
    private int displacements;
    private String efficiency;

    public Engine(String engineModel, int power, int displacements, String efficiency){
        this.engineModel = engineModel;
        this.power = power;
        this.displacements = displacements;
        this.efficiency = efficiency;
    }

    public String getEngineModel(){
        return this.engineModel;
    }
    public int getPower(){
        return  this.power;
    }
    public int getDisplacements(){
        return this.displacements;
    }
    public String getEfficiency(){
        return this.efficiency;
    }
}
