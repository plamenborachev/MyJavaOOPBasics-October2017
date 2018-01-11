package p04MordorsCrueltyPlan;

public class Gandalf {
    private int happiness;
    private String mood;

    public Gandalf() {
    }

    public int getHappiness() {
        return this.happiness;
    }

    public void setHappiness(String food){
        if ("Cram".equalsIgnoreCase(food)){
            this.happiness += 2;
        } else if ("lembas".equalsIgnoreCase(food)){
            this.happiness += 3;
        } else if ("apple".equalsIgnoreCase(food)){
            this.happiness += 1;
        } else if ("melon".equalsIgnoreCase(food)){
            this.happiness += 1;
        } else if ("honeycake".equalsIgnoreCase(food)){
            this.happiness += 5;
        } else if ("mushrooms".equalsIgnoreCase(food)){
            this.happiness -= 10;
        } else {
            this.happiness -= 1;
        }
    }

    public String getMood(){
        if(this.happiness < -5){
            return "Angry";
        } else if(this.happiness < 0){
            return "Sad";
        } else if(this.happiness < 15){
            return "Happy";
        } else {
            return "JavaScript";
        }
    }
}
