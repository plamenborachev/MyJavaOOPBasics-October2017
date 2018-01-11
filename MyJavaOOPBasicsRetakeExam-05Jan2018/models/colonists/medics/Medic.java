package models.colonists.medics;

import models.colonists.Colonist;

public abstract class Medic extends Colonist {

    private static final int MEDICS_COMMON_BONUS = 2;

    private String sign;

    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    protected String getSign() {
        return this.sign;
    }

    @Override
    public int getPotential() {
        return super.getTalent() + MEDICS_COMMON_BONUS;
    }
}
