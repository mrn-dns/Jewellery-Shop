package utils;

import java.util.Iterator;

public class GenLinkedList<E> implements Iterable<E> {

    public Node<E> head;
    public Node<E> temp;

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTemp() {
        return temp;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void setTemp(Node<E> temp) {
        this.temp = temp;
    }

    public void addElement(E c) {
        head= new Node<>(head,c);
        temp=head;
    }

    public void removeElementByIndex(int index) { //used only for listlength method in GenLinkedList
        Node<E> temp=head;
        int count=0;

        if(index==0) { //if the element is the head
            head=head.getNext();
            return;
        }

        while(temp!=null && count++<index-1) temp=temp.getNext();
        if(temp!=null) {
            temp.setNext(temp.getNext().getNext());
        }
    }

    public int listLength()
    {
        Node temp = head; // make a copy of the head
        int counter = 0;
        while (temp != null)  //while there is a node after the head
        {
            counter++; //the counter will start counting
            temp = temp.next; //then when the head
        }
        return counter;  // when there is nothing in front of the head it returns how many nodes were counted
    }

    public void removeElementByObject(E elem) {
        Node<E> temp=head;

        //special case where there is only 1 element in the list
        if(elem==head.getContents()) {
            head=head.getNext();
            return;
        }
        //for 2 or more elements
        while(temp.getNext()!=null && !temp.getNext().getContents().equals(elem)) temp=temp.getNext();
        if(temp.getNext()!=null) {
            temp.setNext(temp.getNext().getNext());
        }

    }

    public void clear() {head=null;}

    @Override
    public Iterator<E> iterator() {
        return new GenIterator<E>(head);
    }
}
