package p06RawData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tyre> tyres;

    public Car(String model, Engine engine, Cargo cargo){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = new ArrayList<>();
    }

    public void setTyres(List<Tyre> tyres){
        this.tyres = tyres;
    }
    public Cargo getCargo(){
        return this.cargo;
    }
    public List<Tyre> getTyres(){
        return this.tyres;
    }
    public Engine getEngine(){
        return this.engine;
    }
}
