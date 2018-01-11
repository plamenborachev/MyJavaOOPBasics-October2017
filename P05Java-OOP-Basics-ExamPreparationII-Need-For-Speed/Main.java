import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        CarManager carManager = new CarManager();

        while(!"Cops Are Here".equalsIgnoreCase(input)){
            String[] commandTokens = input.split("\\s+");
            switch (commandTokens[0]){
                case "register":
                    int carId = Integer.parseInt(commandTokens[1]);
                    String carType = commandTokens[2];
                    String brand = commandTokens[3];
                    String model = commandTokens[4];
                    int year = Integer.parseInt(commandTokens[5]);
                    int horsepower = Integer.parseInt(commandTokens[6]);
                    int acceleration = Integer.parseInt(commandTokens[7]);
                    int suspension = Integer.parseInt(commandTokens[8]);
                    int durability = Integer.parseInt(commandTokens[9]);
                    carManager.register(carId, carType, brand, model, year, horsepower, acceleration,
                            suspension, durability);
                    break;
                case "check":
                    carId = Integer.parseInt(commandTokens[1]);
                    System.out.println(carManager.check(carId));;
                    break;
                case "open":
                    int raceId = Integer.parseInt(commandTokens[1]);
                    String raceType = commandTokens[2];
                    int length = Integer.parseInt(commandTokens[3]);
                    String route = commandTokens[4];
                    int prizePool = Integer.parseInt(commandTokens[5]);
                    carManager.open(raceId, raceType, length, route, prizePool);
                    break;
                case "participate":
                    carId = Integer.parseInt(commandTokens[1]);
                    raceId = Integer.parseInt(commandTokens[2]);
                    carManager.participate(carId, raceId);
                    break;
                case "start":
                    raceId = Integer.parseInt(commandTokens[1]);
                    System.out.println(carManager.start(raceId));
                    break;
                case "park":
                    carId = Integer.parseInt(commandTokens[1]);
                    carManager.park(carId);
                    break;
                case "unpark":
                    carId = Integer.parseInt(commandTokens[1]);
                    carManager.unpark(carId);
                    break;
                case "tune":
                    int tuneIndex = Integer.parseInt(commandTokens[1]);
                    String tuneAddOn = commandTokens[2];
                    carManager.tune(tuneIndex, tuneAddOn);
                    break;
            }
            input = reader.readLine();
        }
    }
}
