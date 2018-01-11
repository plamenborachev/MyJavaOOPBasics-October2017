package p01Vehicles;

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

        Vehicle car = new Car(carFuel, carLitersPerKm);

        String[] truckTokens = reader.readLine().split("\\s+");
        Double truckFuel = Double.parseDouble(truckTokens[1]);
        Double truckLitersPerKm = Double.parseDouble(truckTokens[2]);

        Vehicle truck = new Truck(truckFuel, truckLitersPerKm);

        int n = Integer.parseInt(reader.readLine());

        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (int i = 0; i < n; i++) {
            String[] commandTokens = reader.readLine().split("\\s+");
            if ("Drive".equalsIgnoreCase(commandTokens[0])){
                double distance = Double.parseDouble(commandTokens[2]);
                try{
                    if ("Car".equalsIgnoreCase(commandTokens[1])){
                        car.drive(distance);
                    } else if ("Truck".equalsIgnoreCase(commandTokens[1])){
                        truck.drive(distance);
                    }
                    System.out.println(String.format("%s travelled %s km", commandTokens[1], decimalFormat.format(distance)));
                } catch (IllegalStateException ise){
                    System.out.println(ise.getMessage());
                }
            } else if("Refuel".equalsIgnoreCase(commandTokens[0])){
                double fuel = Double.parseDouble(commandTokens[2]);
                if ("Car".equalsIgnoreCase(commandTokens[1])){
                    car.refuel(fuel);
                } else if ("Truck".equalsIgnoreCase(commandTokens[1])){
                    truck.refuel(fuel);
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
