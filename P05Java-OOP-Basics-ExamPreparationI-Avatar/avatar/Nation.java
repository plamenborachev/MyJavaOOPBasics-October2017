package avatar;

import avatar.benders.Bender;
import avatar.monuments.Monument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nation {
    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation() {
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    public List<Bender> getBenders() {
        return Collections.unmodifiableList(this.benders);
    }

    public List<Monument> getMonuments() {
        return Collections.unmodifiableList(this.monuments);
    }

    public void addBender(Bender bender) {
        this.benders.add(bender);
    }

    public void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    public double calculateNationPower() {
        double total = 0.0;
        for (Bender bender : benders) {
            total += bender.getTotalPower();
        }
        double monumentsTotalPower = 0.0;
        for (Monument monument : monuments) {
            monumentsTotalPower += monument.getPower();
        }
        total += (total / 100) * monumentsTotalPower;
        return total;
    }

    public void deleteAllBenders() {
        this.benders.clear();
    }

    public void deleteAllMonuments() {
        this.monuments.clear();
    }
}
