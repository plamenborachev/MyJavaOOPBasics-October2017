package models.colonists.engineers;

import models.colonists.Colonist;

public abstract class Engineer extends Colonist {

    private static final int ENGINEER_AGE_NEEDED_FOR_ADDITIONAL_BONUS = 30;
    private static final int ENGINEER_CLASS_BONUS = 3;
    private static final int ADDITIONAL_AGE_BONUS = 2;

    protected Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        if (super.getAge() > ENGINEER_AGE_NEEDED_FOR_ADDITIONAL_BONUS){
            return super.getTalent() + ENGINEER_CLASS_BONUS + ADDITIONAL_AGE_BONUS;
        }
        return super.getTalent() + ENGINEER_CLASS_BONUS;
    }


}
