package p06FootballTeamGenerator;

public class Player {
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;
    private double overallSkill;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
        this.setOverallSkill();
    }

    public String getName(){
        return  this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(double endurance) {
        if (endurance < 0 || 100 < endurance) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(double sprint) {
        if (sprint < 0 || 100 < sprint) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(double dribble) {
        if (dribble < 0 || 100 < dribble) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(double passing) {
        if (passing < 0 || 100 < passing) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(double shooting) {
        if (shooting < 0 || 100 < shooting) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public double getOverallSkill() {
        return this.overallSkill;
    }

    private void setOverallSkill() {
        this.overallSkill = (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5;
    }
}
