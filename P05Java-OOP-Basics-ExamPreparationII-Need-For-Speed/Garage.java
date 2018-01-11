import Cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void parkCar(Car car){
        this.parkedCars.add(car);
    }

    public void unparkCar(Car car){
        this.parkedCars.remove(car);
    }

    public List<Car> getParkedCars(){
        return Collections.unmodifiableList(parkedCars);
    }


}
