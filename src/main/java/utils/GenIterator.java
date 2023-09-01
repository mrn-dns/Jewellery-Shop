package utils;

import java.util.Iterator;

public class GenIterator<F> implements Iterator<F> {

    private Node<F> pos;
    public GenIterator(Node<F> fnode) {pos=fnode;}

    @Override
    public boolean hasNext() {
        return pos!=null;
    }

    @Override
    public F next() {
        Node<F> temp=pos;
        pos=pos.getNext();
        return temp.getContents();
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
