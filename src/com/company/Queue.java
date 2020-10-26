package com.company;

/////////////////////////////////////////////////////////////////////////////
// demonstrates Queue
// with: insert() | remove() | peek() | isFull() | isEmpty() | size()

class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    // -------------------------------------------------------------------------
    // constructor:
    public Queue(int size){
        maxSize = size;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // -------------------------------------------------------------------------
    // insert(): put item at the rear of the Queue
    public void insert(long value){

        // deal with the wrap-around ->
        // if a circular queue must exist when there is no other index for rear to take at the end
        if(rear == maxSize - 1){
            rear = -1;
        }

        // increment rear and insert - to 0
        queArray[++rear] = value;
        nItems++; // add an item to the list
    }

    // -------------------------------------------------------------------------
    // remove(): take from front of queue:
    public long remove(){

        // get value and increment front:
        long temp = queArray[front++];

        // circular queue: deal with wrap-around
        if(front == maxSize){
            // the index of front is at the end of the array:
            // bring it back to the first index
            front = 0;
        }
        nItems--;
        return temp;
    }
    // -------------------------------------------------------------------------
    // peekFront(): take from front of queue:
    public long peekFront(){
        return queArray[front];
    }
    // -------------------------------------------------------------------------
    // isEmpty(): take from front of queue:
    public boolean isEmpty(){
        return (nItems == 0);
    }

    // -------------------------------------------------------------------------
    // isFull(): take from front of queue:
    // true if queue is full
    public boolean isFull(){
        return (nItems == maxSize);
    }


    // -------------------------------------------------------------------------
    // size(): take from front of queue:
    public int size(){
        return nItems;
    }
} // ends Queue class

///////////////////////////////////////////////////////////////////////////////
//// QUEUE APP -> UTILIZE FROM THE PROGRAM
class QueueApp{

    public static void main(String[] args) {

        // queue holds 5 items:
        Queue theQueue = new Queue(5);

        // insert 4 items:
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        // remove 3 items: 10,20,30
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        // insert 4 more items:
        // wraps - around now
        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        // remove and display all of the items:
        while(!theQueue.isEmpty()){

            long removeVal = theQueue.remove();

            System.out.println(removeVal);
        }
        System.out.println("");
    }
} // ends QueueApp