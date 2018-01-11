package p05SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedList<Car> cars = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = reader.readLine().split("\\s+");
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCost = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            cars.add(car);
        }

        String input = reader.readLine();

        while (!"End".equalsIgnoreCase(input)){
            String[] commandTokens = input.split("\\s+");
            String carModel = commandTokens[1];
            int amountOfKm = Integer.parseInt(commandTokens[2]);

            cars.stream()
                    .filter(car -> car.getModel().equalsIgnoreCase(carModel))
                    .forEach(car -> {
                        if (car.ifCarCanMoveSomeDistance(amountOfKm)){
                            car.setFuelAmount(amountOfKm);
                            car.setDistanceTraveled(amountOfKm);
                        } else {
                            System.out.println("Insufficient fuel for the drive");
                        }
                    });
            input = reader.readLine();
        }
        for (Car car: cars) {
            System.out.printf(car.toString());
        }
    }
}
