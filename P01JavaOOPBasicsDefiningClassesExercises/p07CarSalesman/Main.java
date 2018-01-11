package p07CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        List<Engine> engines = new ArrayList<>();
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] engineParams = reader.readLine().split("\\s+");
            String engineModel = engineParams[0];
            int power = Integer.parseInt(engineParams[1]);
            int displacements = 0;
            String efficiency = "";
            if (engineParams.length > 2) {
                try {
                    displacements = Integer.parseInt(engineParams[2]);
                } catch (Exception e) {
                    efficiency = engineParams[2];
                }
                if (engineParams.length == 4) {
                    if (efficiency.isEmpty()) {
                        efficiency = engineParams[3];
                    } else {
                        displacements = Integer.parseInt(engineParams[3]);
                    }
                }
            }
            Engine engine = new Engine(engineModel, power, displacements, efficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] carParams = reader.readLine().split("\\s+");
            String carModel = carParams[0];
            String engineModel = carParams[1];
            int weight = 0;
            String color = "";

            if (carParams.length > 2) {
                try {
                    weight = Integer.parseInt(carParams[2]);
                } catch (Exception e) {
                    color = carParams[2];
                }
                if (carParams.length == 4) {
                    if (color.isEmpty()) {
                        color = carParams[3];
                    } else {
                        weight = Integer.parseInt(carParams[3]);
                    }
                }
            }
            List<Engine> filteredEngine = engines.stream()
                    .filter(e -> e.getEngineModel().equals(engineModel))
                    .collect(Collectors.toList());
            Car car = new Car(carModel, filteredEngine.get(0), weight, color);
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.getCarModel() + ":");
            System.out.println("  " + car.getEngine().getEngineModel() + ":");
            System.out.println("    Power: " + car.getEngine().getPower());
            System.out.println("    Displacement: " + (car.getEngine().getDisplacements() != 0 ? car.getEngine().getDisplacements() : "n/a"));
            System.out.println("    Efficiency: " + (!car.getEngine().getEfficiency().equals("") ? car.getEngine().getEfficiency() : "n/a"));
            System.out.println("  Weight: " + (car.getWeight() != 0 ? car.getWeight() : "n/a"));
            System.out.println("  Color: " + (!car.getColor().equals("") ? car.getColor() : "n/a"));
        }
    }
}
