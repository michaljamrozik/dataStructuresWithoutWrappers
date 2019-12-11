package dataStructuresWithoutWrappers.stack;

import dataStructuresWithoutWrappers.Person;

public class CustomStack {

    private int size;
    private Person last;


    public void add(Person person) {
        if (size == 0) {
            last = person;
            size++;
        } else {
            Person temp = last;
            while (temp.getPrevious() != null) {
                temp = temp.getPrevious();
            }
            temp.setPrevious(person);
            person.setPrevious(null);
            size++;
        }
    }

    public void remove() {
        if(size==0){
            System.out.println("Operation is impossible, stack is empty");
        }
        else if (size == 1) {
            last = null;
            size--;
        } else {
            Person temp = last;
            while (temp.getPrevious().getPrevious() != null) {
                temp = temp.getPrevious();
            }
            temp.setPrevious(null);
            size--;
        }
    }


    public int getSize() {
        System.out.println("Stack's size: " + size);
        return size;
    }

    public Person getLast() {
        return last;
    }

    @Override
    public String toString() {
        String result = "Stack[";
        Person temp = last;
        if (size == 0) {
            return "Stack is empty";
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
