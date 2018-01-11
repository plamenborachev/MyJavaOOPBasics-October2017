package p02VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split("\\s+");
        Double carFuel = Double.parseDouble(carTokens[1]);
        Double carLitersPerKm = Double.parseDouble(carTokens[2]);
        Double carTank = Double.parseDouble(carTokens[3]);

        Car car = new Car(carTank, carFuel, carLitersPerKm);

        String[] truckTokens = reader.readLine().split("\\s+");
        Double truckFuel = Double.parseDouble(truckTokens[1]);
        Double truckLitersPerKm = Double.parseDouble(truckTokens[2]);
        Double truckTank = Double.parseDouble(truckTokens[3]);

        Truck truck = new Truck(truckTank, truckFuel, truckLitersPerKm);

        String[] busTokens = reader.readLine().split("\\s+");
        Double busFuel = Double.parseDouble(busTokens[1]);
        Double busLitersPerKm = Double.parseDouble(busTokens[2]);
        Double busTank = Double.parseDouble(busTokens[3]);

        Bus bus = new Bus(busTank, busFuel, busLitersPerKm);

        int n = Integer.parseInt(reader.readLine());

        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (int i = 0; i < n; i++) {
            String[] commandTokens = reader.readLine().split("\\s+");
            try {
                if ("Drive".equalsIgnoreCase(commandTokens[0])) {
                    double distance = Double.parseDouble(commandTokens[2]);
                    if ("Car".equalsIgnoreCase(commandTokens[1])) {
                        car.drive(distance);
                    } else if ("Truck".equalsIgnoreCase(commandTokens[1])) {
                        truck.drive(distance);
                    } else if ("Bus".equalsIgnoreCase(commandTokens[1])) {
                        bus.driveWithPeople(distance);
                    }
                    System.out.println(String.format("%s travelled %s km", commandTokens[1], decimalFormat.format(distance)));
                } else if ("DriveEmpty".equalsIgnoreCase(commandTokens[0])) {
                    double distance = Double.parseDouble(commandTokens[2]);
                    bus.drive(distance);
                } else if ("Refuel".equalsIgnoreCase(commandTokens[0])) {
                    double fuel = Double.parseDouble(commandTokens[2]);
                    if ("Car".equalsIgnoreCase(commandTokens[1])) {
                        car.refuel(fuel);
                    } else if ("Truck".equalsIgnoreCase(commandTokens[1])) {
                        truck.refuel(fuel);
                    } else if ("Bus".equalsIgnoreCase(commandTokens[1])) {
                        bus.refuel(fuel);
                    }
                }
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
