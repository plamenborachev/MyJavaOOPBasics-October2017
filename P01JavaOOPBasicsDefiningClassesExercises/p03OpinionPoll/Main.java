package p03OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, Person> personTreeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.valueOf(tokens[1]);

            Person person = new Person(name, age);

            personTreeMap.putIfAbsent(name, person);
        }

        personTreeMap.entrySet().stream()
                .filter(kv -> kv.getValue().getAge() > 30)
                .forEach(kv -> System.out.println(kv.getValue().getName() + " - " + kv.getValue().getAge()));
    }
}
