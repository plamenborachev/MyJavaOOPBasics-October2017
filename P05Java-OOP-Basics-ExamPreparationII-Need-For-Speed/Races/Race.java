package Races;

import Cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public void addCar(Car car) {
        this.participants.add(car);
    }

    private int calculateMoneyWon(int placeTaken) {
        if (placeTaken == 1) {
            return this.prizePool * 50 / 100;
        } else if (placeTaken == 2) {
            return this.prizePool * 30 / 100;
        } else {
            return this.prizePool * 20 / 100;
        }
    }

    @Override
    public String toString() {
        String raceType = this.getClass().getSimpleName();
        List<Car> winners = this.participants.stream()
                .sorted((car1, car2) -> Integer.compare(car2.calculatePerformancePoints(raceType),
                        car1.calculatePerformancePoints(raceType)))
                .limit(3)
                .collect(Collectors.toList());
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", this.route, this.length))
                .append(System.lineSeparator());
        for (Car car : winners) {
            sb.append(java.lang.String.format("%d. %s %s %dPP - $%d",
                    ++counter,
                    car.getBrand(),
                    car.getModel(),
                    car.calculatePerformancePoints(raceType),
                    this.calculateMoneyWon(counter)))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
