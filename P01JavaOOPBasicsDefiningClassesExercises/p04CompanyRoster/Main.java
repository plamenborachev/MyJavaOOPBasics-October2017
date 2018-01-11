package p04CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        Map<String, List<Employee>> departments = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.valueOf(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = new Employee(name, salary, position, department);

            if (tokens.length > 4) {
                String email;
                int age;
                if (tokens[4].contains("@")) {
                    email = tokens[4];
                    employee.setEmail(email);
                    if (tokens.length == 6) {
                        age = Integer.valueOf(tokens[5]);
                        employee.setAge(age);
                    }
                } else {
                    age = Integer.valueOf(tokens[4]);
                    employee.setAge(age);
                    if (tokens.length == 6) {
                        email = tokens[5];
                        employee.setEmail(email);
                    }
                }
            }

            departments.putIfAbsent(department, new ArrayList<>());
            departments.get(department).add(employee);
        }

        departments.entrySet().stream()
                .sorted((d1, d2) -> Double.compare(
                        d2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(e -> {
                    System.out.printf("Highest Average Salary: %s%n", e.getKey());
                        e.getValue().stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .forEach(empl -> System.out.printf("%s %.2f %s %d%n",
                                empl.getName(), empl.getSalary(), empl.getEmail(), empl.getAge()
                        ));
                });
    }
}
