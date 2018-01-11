import Controller.HealthManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HealthManager healthManager = new HealthManager();

        while(!"BEER IS COMING".equals(input)){
            String[] tokens = input.split("\\s+");
            String output = null;
            switch (tokens[0]){
                case "checkCondition":
                    String organismName = tokens[1];
                    System.out.println(healthManager.checkCondition(organismName));
                    break;
                case "createOrganism":
                    organismName = tokens[1];
                    System.out.println(healthManager.createOrganism(organismName));
                    break;
                case "addCluster":
                    organismName = tokens[1];
                    String clusterId = tokens[2];
                    int rows = Integer.parseInt(tokens[3]);
                    int cols = Integer.parseInt(tokens[4]);
                    output = healthManager.addCluster(organismName, clusterId, rows, cols);
                    if (output != null){
                        System.out.println(output);
                    }
                    break;
                case "addCell":
                    organismName = tokens[1];
                    clusterId = tokens[2];
                    String cellTYpe = tokens[3];
                    String cellId = tokens[4];
                    int health = Integer.parseInt(tokens[5]);
                    int positionRow = Integer.parseInt(tokens[6]);
                    int positionCol = Integer.parseInt(tokens[7]);
                    int additionalProperty = Integer.parseInt(tokens[8]);
                    output = healthManager.addCell(organismName, clusterId, cellTYpe, cellId, health, positionRow, positionCol, additionalProperty);
                    if (output != null){
                        System.out.println(output);
                    }
                    break;
                case "activateCluster":
                    organismName = tokens[1];
                    output = healthManager.activateCluster(organismName);
                    if (output != null){
                        System.out.println(output);
                    }
                    break;
            }
            input = reader.readLine();
        }
    }
}
