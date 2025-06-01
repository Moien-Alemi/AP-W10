package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private final int maxSize;

    public CustomStack(int n) {
        list = new CustomLinkedList<>();
        maxSize = n;
    }

    @Override
    public boolean add(Object t) {
        if(size() == maxSize)
            throw new IllegalStateException("Stack is full");
        list.addLast((T) t);
        return true;
    }

    @Override
    public boolean offer(Object t) {
        if(size() == maxSize)
            return false;
        list.addLast((T) t);
        return true;
    }

    @Override
    public T remove() {
        if(list.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }

        return list.removeLast();
    }

    @Override
    public T poll() {
        if(size() == 0)
            return null;
        return list.removeLast();
    }

    @Override
    public T element() {
        if(size() == 0)
            throw new NoSuchElementException("Stack is empty");

        return list.getLast();
    }

    @Override
    public T peek() {
        if(size() == 0)
            return null;

        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}