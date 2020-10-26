package com.company;

/////////////////////////////////////////////////////////////////////////////
// demonstrates StringQueue class
// with: insert() | remove() | peek() | isFull() | isEmpty() | size()

public class StringQueue {

    private int maxSize;
    private String[] stringQueueArray;
    private int front;
    private int rear;
    private int nItems;

    // -------------------------------------------------------------------------
    // constructor:
    public StringQueue(int size){
        maxSize = size;
        stringQueueArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // -------------------------------------------------------------------------
    // insert(): put item at the rear of the Queue
    public void insert(String strValue){

        // deal with the wrap-around ->
        // if a circular queue must exist when there is no other index for rear to take at the end
        if(rear == maxSize - 1){
            rear = -1;
        }

        // increment rear and insert - to 0
        stringQueueArray[++rear] = strValue;
        nItems++; // add an item to the list
    }

    // -------------------------------------------------------------------------
    // remove(): take from front of queue:
    public String remove(){

        // get value and increment front:
        String temp = stringQueueArray[front++];

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
    public String peekFront(){
        return stringQueueArray[front];
    }

    // -------------------------------------------------------------------------
    // display(): prints from front of queue to the end:
    public void display(){

        System.out.println("The queue from the front to rear is: ");

        // deal with the wrap around and display from front to end
        if(front == maxSize){
            for(int i = 0; i < this.rear; i++){
                System.out.println("index[" + i + "] = " + stringQueueArray[i]);
            }
        } else {
            for(int i = 0; i < maxSize - 1; i++){
                System.out.println("index[" + i + "] = " + stringQueueArray[i]);
            }
        }
        System.out.println();
    } // ends display()

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

    // -------------------------------------------------------------------------
    // Accessor functions: getFront() + getRear()
    public int getFront(){
        return front;
    }

    public int getRear(){
        return rear;
    }
} // ends StringQueue class

///////////////////////////////////////////////////////////////////////////////
// StringQueueApp
class StringQueueApp{
    public static void main(String[] args) {

        StringQueue theQueue = new StringQueue(6); // queue holds five items:

        // insert 4 items:
        theQueue.insert("The path");
        theQueue.insert("from the earth");
        theQueue.insert("to the stars");
        theQueue.insert("is a long one!");
        theQueue.insert("The End");

        // display all items
        theQueue.display();

        // remove an item:
        // this will be removed: "the path"
        System.out.println("I will now remove the first value in the queue:");
        // front:
        System.out.println("Front before dequeue: " + theQueue.getFront());
        // rear:
        System.out.println("Rear before dequeue:" + theQueue.getRear());
        // I will remove the first value from the queue:
        theQueue.remove();

        // It will have all of the values but these have changed:
        // front:
        System.out.println("Front after dequeue: " + theQueue.getFront());
        // rear:
        System.out.println("Rear after dequeue: " + theQueue.getRear());
        System.out.println();

        // remove all items then add them at the end:
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();


        // Print the status of the front and rear after removing:
        System.out.println("I will now show the status of the circular queue:");
        // front:
        System.out.println("Front before dequeue: " + theQueue.getFront());
        // rear:
        System.out.println("Rear before dequeue:" + theQueue.getRear());


        theQueue.insert("First Wrap-Around Value");
        theQueue.display(); // this will show ^ @ index 0



        // It will have all of the values but these have changed:
        // front:
        System.out.println("Front after dequeue: " + theQueue.getFront());
        // rear:
        System.out.println("Rear after dequeue: " + theQueue.getRear());
        System.out.println();
    }
} // ends StringQueue