package models.colonists.medics;

public class Surgeon extends Medic {

    private static final int GP_MIN_AGE_NEEDED_FOR_ADDITIONAL_BONUS = 25;
    private static final int GP_MAX_AGE_NEEDED_FOR_ADDITIONAL_BONUS = 35;
    private static final int GP_AGE_BONUS = 2;
    private static final int GP_SIGN_BONUS = 3;
    private static final int GP_SIGN_PENALTY = -3;

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int additionalBonus = 0;
        if (super.getAge() > GP_MIN_AGE_NEEDED_FOR_ADDITIONAL_BONUS
                && super.getAge() < GP_MAX_AGE_NEEDED_FOR_ADDITIONAL_BONUS){
            additionalBonus += GP_AGE_BONUS;
        }
        if ("precise".equals(super.getSign())){
            additionalBonus += GP_SIGN_BONUS;
        } else if ("butcher".equals(super.getSign())){
            additionalBonus += GP_SIGN_PENALTY;
        }
        return super.getPotential() + additionalBonus;
    }
}
