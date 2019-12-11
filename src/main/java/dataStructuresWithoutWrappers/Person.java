package dataStructuresWithoutWrappers;


public class Person {

    private String name;
    private String surname;
    private Person previous;

    public Person getPrevious() {
        return previous;
    }

    public void setPrevious(Person previous) {
        this.previous = previous;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name +", " + surname;
    }
}

