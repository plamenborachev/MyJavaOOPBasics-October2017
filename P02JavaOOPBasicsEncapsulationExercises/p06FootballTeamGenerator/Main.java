package p06FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(";");

        Map<String, Team> teams = new HashMap<>();

        while (!"END".equals(input[0])) {
            String teamName = input[1];
            if ("Team".equals(input[0])) {
                try{
                    Team team = new Team(teamName);
                    teams.putIfAbsent(teamName, team);
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
            } else if ("Add".equals(input[0])) {
                try{
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        String playerName = input[2];
                        double endurance = Double.parseDouble(input[3]);
                        double sprint = Double.parseDouble(input[4]);
                        double dribble = Double.parseDouble(input[5]);
                        double passing = Double.parseDouble(input[6]);
                        double shooting = Double.parseDouble(input[7]);
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamName).addPlayer(player);
                    }
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
            } else if ("Remove".equals(input[0])) {
                if (!teams.containsKey(teamName)) {
                    System.out.printf("Team %s does not exist.%n", teamName);
                } else {
                    try{
                        String playerName = input[2];
                        teams.get(teamName).removePlayer(playerName);
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                }
            } else if ("Rating".equals(input[0])) {
                if (teams.containsKey(teamName)){
                    System.out.println(teams.get(teamName).toString());
                } else {
                    System.out.printf("Team %s does not exist.%n", teamName);
                }
            }
            input = reader.readLine().split(";");
        }
    }
}
