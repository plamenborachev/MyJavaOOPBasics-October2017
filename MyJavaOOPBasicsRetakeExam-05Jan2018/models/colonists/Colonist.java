package models.colonists;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    protected Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    protected int getTalent() {
        return this.talent;
    }

    protected int getAge() {
        return this.age;
    }

    public abstract int getPotential();

    public void grow(int years) {
        this.age += years;
    }

}
