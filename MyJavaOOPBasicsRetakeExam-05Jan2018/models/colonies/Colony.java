package models.colonies;

import factories.FamilyFactory;
import models.colonists.Colonist;
import models.families.Family;

import java.util.*;
import java.util.stream.Collectors;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new LinkedHashMap<>();
    }

    public void addColonist(Colonist colonist) {
        String familyId = colonist.getFamilyId();
        Family family = null;
        if (!this.families.containsKey(familyId)) {
            if (this.families.size() == this.getMaxFamilyCount()) {
                System.out.println("colony is full");
                return;
            } else {
                family = FamilyFactory.createFamily(familyId);
                this.families.put(familyId, family);
            }
        }
        if (this.families.get(familyId).getColonists().size() == this.getMaxFamilyCapacity()) {
            System.out.println("family is full");
            return;
        }
        this.families.get(familyId).addColonist(colonist);
    }

    public void removeColonist(String familyId, String memberId) {
        if (this.families.containsKey(familyId)) {
            if (this.families.get(familyId).getColonists().containsKey(memberId)) {
                this.families.get(familyId).removeColonist(memberId);
                if (this.families.get(familyId).getColonists().size() == 0) {
                    this.removeFamily(familyId);
                }
            }
        }
    }

    public void removeFamily(String id) {
        if (this.families.containsKey(id)){
            this.families.remove(id);
        }
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        if (this.families.containsKey(familyId)) {
            return this.families.get(familyId).getColonists().values().stream().collect(Collectors.toList());
        }
        return null;
    }

    public void grow(int years) {
        this.families.values().stream()
                .forEach(f -> f.getColonists().values().stream()
                        .forEach(c -> c.grow(years)));
    }

    public int getPotential() {
        int totalPotential = 0;
        for (Family family : this.families.values()) {
            for (Colonist colonist : family.getColonists().values()) {
                totalPotential += colonist.getPotential();
            }
        }
        return totalPotential;
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d", this.families.size(), this.getMaxFamilyCount()))
                .append(System.lineSeparator());
        this.families.values().stream()
                .sorted(Comparator.comparing(Family::getId))
                .forEach(f -> sb.append(String.format("-%s: %d/%d",
                        f.getId(), f.getColonists().size(), this.getMaxFamilyCapacity()))
                        .append(System.lineSeparator()));
        return sb.toString().trim();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public Map<String, Family> getFamilies() {
        return Collections.unmodifiableMap(this.families);
    }

    public String printFamily(String familyId) {
        StringBuilder sb = new StringBuilder();
        sb.append(familyId + ":").append(System.lineSeparator());
        this.getColonistsByFamilyId(familyId).stream()
                .sorted(Comparator.comparing(Colonist::getId))
                .forEach(c -> sb.append(String.format("-%s: %d", c.getId(), c.getPotential())));
        return sb.toString().trim();
    }
}
