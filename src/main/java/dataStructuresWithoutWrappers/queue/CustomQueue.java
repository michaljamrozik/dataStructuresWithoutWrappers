package dataStructuresWithoutWrappers.queue;

import dataStructuresWithoutWrappers.Person;

public class CustomQueue {

    private int size;
    private Person last;

    //złożoność O(1)
    public void add(Person person) {
        person.setPrevious(last);
        setLast(person);
        size++;
    }

    //złożoność O(n)
    public void delete() {
        if (size == 0) {
            System.out.println("Operation is impossible, queue is empty");
        } else if (size == 1) {
            setLast(null);
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

    public boolean contains(Person person){
        Person temp=last;
        while(temp!=null){
            if(temp==person){
             return true;
            }
                temp=temp.getPrevious();
        }
        return false;
    }

    public void setLast(Person last) {
        this.last = last;
    }

    public Person getLast() {
        System.out.println("Last item in queue: " + last);
        return last;
    }

    public int getSize() {
        System.out.println("Queue's lenght:  " + size);
        return size;
    }

    @Override
    public String toString() {
        String result = "Queue[";
        Person temp = last;
        if (size == 0) {
            return "Queue is empty";
        } else {
            while (temp.getPrevious() != null) {
                result += temp + " --> ";
                temp = temp.getPrevious();
            } result+=temp;
        }
        return result + "]";


    }
}
