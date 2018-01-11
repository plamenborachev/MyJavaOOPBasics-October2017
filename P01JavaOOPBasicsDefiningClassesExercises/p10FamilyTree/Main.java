package p10FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String wanted = reader.readLine();
        String command = reader.readLine();

        HashSet<Person> persons = new HashSet<>();

        while (!"End".equalsIgnoreCase(command)) {
            String[] tokens = command.split(" - ");

            if (tokens.length > 1) {
                String parentFirstName = "";
                String parentLastName = "";
                String parentBirthday = "";
                String childFirstName = "";
                String childLastName = "";
                String childBirthday = "";

                if (tokens[0].contains("/")) {
                    parentBirthday = tokens[0];
                    if (tokens[1].contains("/")) {
                        childBirthday = tokens[1];
                    } else {
                        String[] childNames = tokens[1].split("\\s+");
                        childFirstName = childNames[0];
                        childLastName = childNames[1];
                    }
                } else {
                    String[] parentNames = tokens[0].split("\\s+");
                    parentFirstName = parentNames[0];
                    parentLastName = parentNames[1];
                    if (tokens[1].contains("/")) {
                        childBirthday = tokens[1];
                    } else {
                        String[] childNames = tokens[1].split("\\s+");
                        childFirstName = childNames[0];
                        childLastName = childNames[1];
                    }
                }
                Person parent = new Person(parentFirstName, parentLastName, parentBirthday);
                Person child = new Person(childFirstName, childLastName, childBirthday);
                parent.addChild(child);
                child.addParent(parent);
            } else {
                String[] personTokens = tokens[0].split("\\s+");
                String personFirstName = personTokens[0];
                String personLatsName = personTokens[1];
                String personBirthday = personTokens[2];
            }
        }
        command = reader.readLine();
    }
}

