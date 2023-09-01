package utils;

import java.util.Iterator;

public class Node<Data> {

    public Node<Data> next=null;
    public Data contents;

    public Node(Node<Data> next, Data contents) {
        this.next = next;
        this.contents = contents;
    }

    //setters

    public void setNext(Node<Data> next) {
        this.next = next;
    }

    public void setContents(Data c) {contents=c;}

    //getters

    public Node<Data> getNext() {
        return next;
    }

    public Data getContents() {return contents;}

}
