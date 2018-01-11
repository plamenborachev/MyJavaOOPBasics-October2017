package models.colonists.medics;

public class GeneralPractitioner extends Medic {

    private static final int GP_MIN_AGE_NEEDED_FOR_ADDITIONAL_BONUS = 15;
    private static final int GP_AGE_BONUS = 1;
    private static final int GP_SIGN_BONUS = 1;
    private static final int GP_SIGN_PENALTY = -2;

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int additionalBonus = 0;
        if (super.getAge() > GP_MIN_AGE_NEEDED_FOR_ADDITIONAL_BONUS){
            additionalBonus += GP_AGE_BONUS;
        }
        if ("caring".equals(super.getSign())){
            additionalBonus += GP_SIGN_BONUS;
        } else if ("careless".equals(super.getSign())){
            additionalBonus += GP_SIGN_PENALTY;
        }
        return super.getPotential() + additionalBonus;
    }
}
