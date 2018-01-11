import models.colonies.Colony;
import models.colonists.Colonist;
import models.colonists.engineers.HardwareEngineer;
import models.colonists.engineers.SoftwareEngineer;
import models.colonists.medics.GeneralPractitioner;
import models.colonists.medics.Surgeon;
import models.colonists.soldiers.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] colonyTokens = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxFamilyCount = colonyTokens[0];
        int maxFamilyCapacity = colonyTokens[1];

        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        String[] command = reader.readLine().split("\\s+");

        while (!"end".equals(command[0])) {
            switch (command[0]) {
                case "insert":
                    Colonist colonist = null;
                    switch (command[1]) {
                        case "SoftwareEngineer":
                            colonist = new SoftwareEngineer(command[2], command[3], Integer.parseInt(command[4]),
                                    Integer.parseInt(command[5]));
                            break;
                        case "HardwareEngineer":
                            colonist = new HardwareEngineer(command[2], command[3], Integer.parseInt(command[4]),
                                    Integer.parseInt(command[5]));
                            break;
                        case "Soldier":
                            colonist = new Soldier(command[2], command[3], Integer.parseInt(command[4]), Integer
                                    .parseInt(command[5]));
                            break;
                        case "GeneralPractitioner":
                            colonist = new GeneralPractitioner(command[2], command[3], Integer.parseInt(command[4]),
                                    Integer.parseInt(command[5]), command[6]);
                            break;
                        case "Surgeon":
                            colonist = new Surgeon(command[2], command[3], Integer.parseInt(command[4]), Integer
                                    .parseInt(command[5]), command[6]);
                            break;
                    }
                    colony.addColonist(colonist);
                    break;
                case "remove":
                    switch (command[1]) {
                        case "family":
                            colony.removeFamily(command[2]);
                            break;
                        case "colonist":
                            colony.removeColonist(command[2], command[3]);
                            break;
                    }
                    break;
                case "grow":
                    colony.grow(Integer.parseInt(command[1]));
                    break;
                case "potential":
                    System.out.println(String.format("potential: %d", colony.getPotential()));
                    break;
                case "capacity":
                    System.out.println(colony.getCapacity());
                    break;
                case "family":
                    if (!colony.getFamilies().containsKey(command[1])) {
                        System.out.println("family does not exist");
                        break;
                    }
                    System.out.println(colony.printFamily(command[1]));
                    break;
            }
            command = reader.readLine().split("\\s+");
        }
    }
}
