import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        HealthManager healthManager = new HealthManager();

        while (!"BEER IS COMING".equals(input)){
            String[] commandTokens = input.split("\\s+");
            String output;
            switch (commandTokens[0]){
                case "checkCondition":
                    output = healthManager.checkCondition(commandTokens[1]);
                    if (output != null) {
                        System.out.println(output);
                    }
                    break;
                case "createOrganism":
                    output = healthManager.createOrganism(commandTokens[1]);
                    System.out.println(output);
                    break;
                case "addCluster":
                    output = healthManager.addCluster(commandTokens[1], commandTokens[2], Integer.parseInt(commandTokens[3]), Integer.parseInt(commandTokens[4]));
                    if (output != null) {
                        System.out.println(output);
                    }
                    break;
                case "addCell":
                    output = healthManager.addCell(commandTokens[1], commandTokens[2], commandTokens[3], commandTokens[4], Integer.parseInt(commandTokens[5]), Integer.parseInt(commandTokens[6]), Integer.parseInt(commandTokens[7]), Integer.parseInt(commandTokens[8]));
                    if (output != null){
                        System.out.println(output);
                    }
                    break;
                case "activateCluster":
                    output = healthManager.activateCluster(commandTokens[1]);
                    if (output != null){
                        System.out.println(output);
                    }
                    break;
            }
            input = reader.readLine();
        }
    }
}
