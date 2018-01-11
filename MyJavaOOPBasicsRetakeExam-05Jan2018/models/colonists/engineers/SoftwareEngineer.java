package models.colonists.engineers;

public class SoftwareEngineer extends Engineer {

    private static final int SOFTWARE_ENGINEER_FLAT_BONUS = 2;

    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        return super.getPotential() + SOFTWARE_ENGINEER_FLAT_BONUS;
    }
}
