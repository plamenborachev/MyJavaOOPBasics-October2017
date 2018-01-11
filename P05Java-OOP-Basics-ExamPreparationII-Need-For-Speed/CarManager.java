import Cars.Car;
import Cars.PerformanceCar;
import Cars.ShowCar;
import Races.CasualRace;
import Races.DragRace;
import Races.DriftRace;
import Races.Race;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;
        if ("Performance".equals(type)) {
            car = new PerformanceCar(brand, model, yearOfProduction,
                    horsepower, acceleration, suspension, durability);
        } else if ("Show".equals(type)) {
            car = new ShowCar(brand, model, yearOfProduction,
                    horsepower, acceleration, suspension, durability);
        }
        this.cars.putIfAbsent(id, car);
    }

    public String check(int id) {
        if (this.cars.containsKey(id)) {
            Car currentCar = this.cars.get(id);
            return currentCar.toString();
        } else {
            return null;
        }
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        if ("Casual".equals(type)) {
            race = new CasualRace(length, route, prizePool);
        } else if ("Drag".equals(type)) {
            race = new DragRace(length, route, prizePool);
        } else if ("Drift".equals(type)) {
            race = new DriftRace(length, route, prizePool);
        }
        this.races.putIfAbsent(id, race);
    }

    public void participate(int carId, int raceId) {
        if (this.cars.containsKey(carId) && this.races.containsKey(raceId)) {
            Car currentCar = this.cars.get(carId);
            if (!this.garage.getParkedCars().contains(currentCar)) {
                this.races.get(raceId).addCar(currentCar);
            }
        }
    }

    public String start(int id) {
        if (this.races.containsKey(id)) {
            if (this.races.get(id).getParticipants().isEmpty()) {
                return "Cannot start the race with zero participants.";
            } else {
                Race currentRace = this.races.get(id);
                this.races.remove(id);
                return currentRace.toString().trim();
            }
        } else {
            return null;
        }
    }

    public void park(int id) {
        if (this.cars.containsKey(id)) {
            Car currentCar = this.cars.get(id);
            boolean isParticipant = false;
            for (Map.Entry<Integer, Race> race : races.entrySet()) {
                if (race.getValue().getParticipants().contains(currentCar)) {
                    isParticipant = true;
                    break;
                }
            }
            if (!isParticipant) {
                this.garage.parkCar(currentCar);
            }
        }
    }

    public void unpark(int id) {
        if (this.cars.containsKey(id)) {
            Car currentCar = this.cars.get(id);
            if (this.garage.getParkedCars().contains(currentCar)) {
                this.garage.unparkCar(currentCar);
            }
        }
    }

    public void tune(int tuneIndex, String addOn) {
        if (this.garage.getParkedCars().size() != 0) {
            for (Car car : this.garage.getParkedCars()) {
                car.tune(tuneIndex, addOn);
            }
        }
    }
}
