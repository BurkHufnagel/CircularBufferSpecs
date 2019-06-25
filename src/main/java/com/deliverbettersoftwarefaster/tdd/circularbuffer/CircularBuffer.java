package com.deliverbettersoftwarefaster.tdd.circularbuffer;


public class CircularBuffer {
    String[] buffer;
    int head = 0;  // Tracks where to remove from
    int tail = 0;  // Tracks where to add to

    int stored = 0;


    public CircularBuffer(int capacity) {
        if( capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }

        buffer = new String[capacity];
    }


    public void add(String item) {
        buffer[tail] = item;
        incrementTail();

        if(stored < buffer.length) {
            stored++;
        }
    }


    public String remove() {
        String removedItem = buffer[head];
        incrementHead();
        stored--;

        return removedItem;
    }


    public int stored() {
        return stored;
    }


//    public boolean isEmpty() {
//        return stored == 0;
//    }


    protected void incrementHead() {
        head = (head+1) % buffer.length;;
    }


    protected void incrementTail() {
        if((stored > 0) && (tail == head) ) {
            incrementHead();
        }

        tail = (tail+1) % buffer.length;;
    }
}
