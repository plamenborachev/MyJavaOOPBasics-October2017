package models.families;

import models.colonists.Colonist;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Family {

    private String id;
    private Map<String, Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new LinkedHashMap<>();
    }

    public String getId() {
        return this.id;
    }

    public void addColonist(Colonist colonist){
        this.colonists.put(colonist.getId(), colonist);
    }

    public void removeColonist(String colonistId){
        this.colonists.remove(colonistId);
    }

    public Map<String, Colonist> getColonists() {
        return Collections.unmodifiableMap(this.colonists);
    }
}
