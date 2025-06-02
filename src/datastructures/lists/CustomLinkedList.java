package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean add(Object o) {
        if(o == null)
            throw new NullPointerException();
        tail.next = new Node(o);
        tail.next.prev = tail;
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while(current != null){
            if(o.equals(current.data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null)
            throw new NullPointerException();
        Node<T> current = head;
        while(current != null){
            if(o.equals(current.data)){
                current.prev.next = current.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        if(t == null)
            throw new NullPointerException();
        Node<T> newNode = new Node<>(t);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if(size == 0)
            throw new NoSuchElementException();

        T t = head.data;

        if(size == 1){
            head = null;
            tail = null;
        }
        else {
            head.next.prev = null;
            head = head.next;
        }
        size--;
        return t;
    }

    @Override
    public T removeLast() {
        if(size == 0)
            throw new NoSuchElementException();

        T t = tail.data;

        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            tail.prev.next = null;
            tail = tail.prev;
        }
        size--;
        return t;
    }

    @Override
    public T getFirst() {
        if(size == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public T getLast() {
        if(size == 0)
            throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(size == 0)
            throw new NoSuchElementException();

        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current= current.next;
        }
        return current.data;
    }

    @Override
    public Object set(int index, Object element) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(size == 0)
            throw new NoSuchElementException();

        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current= current.next;
        }
        current.data = (T) element;
        return current.data;
    }
}