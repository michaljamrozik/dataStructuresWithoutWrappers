package dataStructuresWithoutWrappers.list;

import dataStructuresWithoutWrappers.Person;

import java.util.List;

public class CustomList {

    private int size;
    private Person last;

    public void setLast(Person last) {
        this.last = last;
    }

    public int getSize() {
        System.out.println("List's size: " + size);
        return size;
    }

    public Person getLast() {
        return last;
    }

    public void add(Person person) {
        person.setPrevious(last);
        last = person;
        size++;
    }

    public void add(Person person, int index) {
        if (index <= 0) {
            System.out.println("Index must be equal to 1 at least");
        } else if (index > size + 1) {
            System.out.println("Index cannot be higher than list's size");
        } else if (index == size + 1) {
            person.setPrevious(last);
            last = person;
            size++;
        } else {
            int tempIndex = size;
            Person temp = last;
            while (tempIndex != index) {
                temp = temp.getPrevious();
                tempIndex--;
            }
            person.setPrevious(temp.getPrevious());
            temp.setPrevious(person);
            size++;
        }
    }

    public void remove(int index) {
        if (index <= 0) {
            System.out.println("Index must be equal to 1 at least");
        } else if (index > size) {
            System.out.println("Index cannot be higher than list's size");
        } else if (index == size) {
            last = last.getPrevious();
            size--;
        } else {
            int tempIndex = size - 1;
            Person temp = last;
            while (tempIndex != index) {
                temp = temp.getPrevious();
                tempIndex--;
            }
            temp.setPrevious(temp.getPrevious().getPrevious());
            size--;
        }

    }

    public void set(int indexToReplace, Person newPerson) {
        if (indexToReplace <= 0) {
            System.out.println("Index must be equal to 1 at least");
        } else if (indexToReplace > size) {
            System.out.println("Index cannot be higher than list's size");
        } else if (indexToReplace == size) {
            newPerson.setPrevious(last.getPrevious());
            last = newPerson;
        } else {
            Person temp = last;
            int tempIndex = size - 1;
            while (tempIndex != indexToReplace) {
                temp = temp.getPrevious();
                tempIndex--;
            }
            newPerson.setPrevious(temp.getPrevious().getPrevious());
            temp.setPrevious(newPerson);
        }

    }

    public void set(Person personToReplace, Person newPerson) {
        if (personToReplace != last) {
            Person temp = last;
            Person index = last.getPrevious();
            while (index != personToReplace) {
                temp = temp.getPrevious();
                index = index.getPrevious();
            }
            newPerson.setPrevious(index.getPrevious());
            temp.setPrevious(newPerson);
        } else {
            newPerson.setPrevious(last.getPrevious());
            last = newPerson;
        }
    }

    public boolean contains(Person person) {
        Person temp = last;
        while (temp != null) {
            if (temp == person) {
                return true;
            }
            temp = temp.getPrevious();
        }
        return false;
    }


    @Override
    public String toString() {
        String result = "List[";
        Person temp = last;
        if (size == 0) {
            return "List is empty";
        } else {
            while (temp.getPrevious() != null) {
                result += temp + " --> ";
                temp = temp.getPrevious();
            }
            result += temp + "]";
        }
        return result;
    }
}
