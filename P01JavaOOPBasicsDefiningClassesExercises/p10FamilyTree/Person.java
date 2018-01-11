package p10FamilyTree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parents;
    private List<Person> children;

    public Person(String firstName, String lastName, String birthday){
        this.setName(firstName, lastName);
        this.birthday = birthday;
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
    }

    private void setName(String firstName, String lastName){
        this.name = firstName + " " + lastName;
    }

    public void addParent(Person parent){
        this.parents.add(parent);
    }

    public void addChild(Person child){
        this.children.add(child);
    }
}
