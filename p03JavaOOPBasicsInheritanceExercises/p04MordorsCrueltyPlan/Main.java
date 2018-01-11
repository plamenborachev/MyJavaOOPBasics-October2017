package p04MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foods = reader.readLine().split("\\s+");

        Gandalf gandalf = new Gandalf();

        for (int i = 0; i < foods.length; i++) {
            gandalf.setHappiness(foods[i]);
        }

        System.out.println(gandalf.getHappiness());
        System.out.println(gandalf.getMood());
    }
}
