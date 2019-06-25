package com.deliverbettersoftwarefaster.tdd.circularbuffer;


public class CircularBuffer {
    String[] buffer;
    int head = 0;  // Tracks where to remove from
    int tail = 0;  // Tracks where to add to

    boolean isEmpty = true;


    public CircularBuffer(int capacity) {
        if( capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }

        buffer = new String[capacity];
    }


    public void add(String item) {
        buffer[tail] = item;
        incrementTail();

        isEmpty = false;
    }


    public String remove() {
        String removedItem = buffer[head];
        incrementHead();
        isEmpty = head == tail;

        return removedItem;
    }


    public int stored() {
        int stored = 0;

        if(isEmpty) {
            return 0;
        }

        if(head == tail) {
            return buffer.length;
        }

        if( tail < head ) {
            return (buffer.length + tail) - head;
        }

        return tail - head;
    }


    public boolean isEmpty() {
        return isEmpty;
    }


    protected void incrementHead() {
        head = (head+1) % buffer.length;;
    }


    protected void incrementTail() {
        if(!isEmpty && (tail == head) ) {
            incrementHead();
        }

        tail = (tail+1) % buffer.length;;
    }
}
