import avatar.Nation;
import avatar.benders.*;
import avatar.monuments.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] commandTokens = reader.readLine().split("\\s+");
        String command = commandTokens[0];

        Nation airNation = new Nation();
        Nation earthNation = new Nation();
        Nation fireNation = new Nation();
        Nation waterNation = new Nation();

        List<String> warIssuers = new LinkedList<>();

        while (!"Quit".equalsIgnoreCase(command)) {
            Bender bender = null;
            Monument monument = null;
            switch (command) {
                case "Bender":
                    String benderType = commandTokens[1];
                    String benderName = commandTokens[2];
                    int power = Integer.parseInt(commandTokens[3]);
                    double secondaryParameter = Double.parseDouble(commandTokens[4]);
                    switch (benderType) {
                        case "Air":
                            bender = new AirBender(benderName, power, secondaryParameter);
                            airNation.addBender(bender);
                            break;
                        case "Water":
                            bender = new WaterBender(benderName, power, secondaryParameter);
                            waterNation.addBender(bender);
                            break;
                        case "Fire":
                            bender = new FireBender(benderName, power, secondaryParameter);
                            fireNation.addBender(bender);
                            break;
                        case "Earth":
                            bender = new EarthBender(benderName, power, secondaryParameter);
                            earthNation.addBender(bender);
                            break;
                    }
                    break;
                case "Monument":
                    String monumentType = commandTokens[1];
                    String monumentName = commandTokens[2];
                    int affinity = Integer.parseInt(commandTokens[3]);
                    switch (monumentType) {
                        case "Air":
                            monument = new AirMonument(monumentName, affinity);
                            airNation.addMonument(monument);
                            break;
                        case "Water":
                            monument = new WaterMonument(monumentName, affinity);
                            waterNation.addMonument(monument);
                            break;
                        case "Fire":
                            monument = new FireMonument(monumentName, affinity);
                            fireNation.addMonument(monument);
                            break;
                        case "Earth":
                            monument = new EarthMonument(monumentName, affinity);
                            earthNation.addMonument(monument);
                            break;
                    }
                    break;
                case "Status":
                    String nation = commandTokens[1];
                    System.out.println(nation + " Nation");
                    switch (nation) {
                        case "Air":
                            getStatus(airNation);
                            break;
                        case "Water":
                            getStatus(waterNation);
                            break;
                        case "Fire":
                            getStatus(fireNation);
                            break;
                        case "Earth":
                            getStatus(earthNation);
                            break;
                    }
                    break;
                case "War":
                    nation = commandTokens[1];
                    warIssuers.add(nation);

                    double airPower = airNation.calculateNationPower();
                    double earthPower = earthNation.calculateNationPower();
                    double firePower = fireNation.calculateNationPower();
                    double waterPower = waterNation.calculateNationPower();

                    if (Math.max(Math.max(airPower, earthPower), Math.max(firePower, waterPower)) == airPower) {
                        clearNationBendersAndMonuments(earthNation, fireNation, waterNation);
                    } else if (Math.max(Math.max(airPower, earthPower), Math.max(firePower, waterPower)) == earthPower) {
                        clearNationBendersAndMonuments(airNation, fireNation, waterNation);
                    } else if (Math.max(Math.max(airPower, earthPower), Math.max(firePower, waterPower)) == firePower) {
                        clearNationBendersAndMonuments(earthNation, airNation, waterNation);
                    } else {
                        clearNationBendersAndMonuments(earthNation, fireNation, airNation);
                    }
                    break;
            }
            commandTokens = reader.readLine().split("\\s+");
            command = commandTokens[0];
        }
        int counter = 0;
        for (String nation : warIssuers) {
            System.out.printf("War %d issued by %s%n", ++counter, nation);
        }
    }

    private static void clearNationBendersAndMonuments(Nation n1, Nation n2, Nation n3) {
        n1.deleteAllBenders();
        n1.deleteAllMonuments();
        n2.deleteAllBenders();
        n2.deleteAllMonuments();
        n3.deleteAllBenders();
        n3.deleteAllMonuments();
    }

    private static void getStatus(Nation nation) {
        if (nation.getBenders().size() > 0) {
            System.out.println("Benders:");
            nation.getBenders().stream().forEach(b -> System.out.println("###" + b));
        } else {
            System.out.println("Benders: None");
        }
        if (nation.getMonuments().size() > 0) {
            System.out.println("Monuments:");
            nation.getMonuments().stream().forEach(m -> System.out.println("###" + m));
        } else {
            System.out.println("Monuments: None");
        }
    }
}
