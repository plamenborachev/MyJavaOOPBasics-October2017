package models.colonists.engineers;

public class HardwareEngineer extends Engineer {

    private static final int HARDWARE_ENGINEER_MAX_AGE_FOR_ADDITIONAL_BONUS = 18;
    private static final int HARDWARE_ENGINEER_ADDITIONAL_AGE_BONUS = 2;

    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        if(super.getAge() < HARDWARE_ENGINEER_MAX_AGE_FOR_ADDITIONAL_BONUS){
            return super.getPotential() + HARDWARE_ENGINEER_ADDITIONAL_AGE_BONUS;
        }
        return super.getPotential();
    }
}
