package p06RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.valueOf(tokens[1]);
            int enginePower = Integer.valueOf(tokens[2]);
            int cargoWeight = Integer.valueOf(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.valueOf(tokens[5]);
            double tire2Pressure = Double.valueOf(tokens[7]);
            double tire3Pressure = Double.valueOf(tokens[9]);
            double tire4Pressure = Double.valueOf(tokens[11]);
            int tire1Age = Integer.valueOf(tokens[6]);
            int tire2Age = Integer.valueOf(tokens[8]);
            int tire3Age = Integer.valueOf(tokens[10]);
            int tire4Age = Integer.valueOf(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tyre tyre1 = new Tyre(tire1Age, tire1Pressure);
            Tyre tyre2 = new Tyre(tire2Age, tire2Pressure);
            Tyre tyre3 = new Tyre(tire3Age, tire3Pressure);
            Tyre tyre4 = new Tyre(tire4Age, tire4Pressure);
            List<Tyre> tyres = new ArrayList<>();
            tyres.addAll(Arrays.asList(tyre1, tyre2, tyre3, tyre4));
            Car car = new Car(model, engine, cargo);
            car.setTyres(tyres);

            cars.putIfAbsent(model, car);
        }

        String command = reader.readLine();

        if ("fragile".equalsIgnoreCase(command)){
            cars.entrySet().stream()
                    .filter(kv -> kv.getValue().getCargo().getType().equalsIgnoreCase("fragile"))
                    .filter(kv -> kv.getValue().getTyres().stream()
                            .filter(t -> t.getPressure() < 1)
                            .collect(Collectors.toList()).size() > 0)
                    .forEach(kv -> System.out.println(kv.getKey()));
        } else if ("flamable".equalsIgnoreCase(command)){
                cars.entrySet().stream()
                        .filter(kv -> kv.getValue().getCargo().getType().equalsIgnoreCase("flamable"))
                        .filter(kv -> kv.getValue().getEngine().getPower() > 250)
                        .forEach(car -> System.out.println(car.getKey()));
            }
    }
}
