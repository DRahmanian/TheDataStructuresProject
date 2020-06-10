package edu.miracosta.cs113.DRahmanian;

import java.util.Arrays;

public class KWArrayList<E> {
//Data  Fields
    /** Default(Initial) Capacity */
    private static final int INITIAL_CAPACITY=10;

    /** Underlying data array */
    //Note: The data type E is instantiated as a generic data type when an object of KWArrayLIst is created
    public E[] theData;

    /** Current size */
    private int size=0;

    /** Current capacity */
     private int capacity =0;

public KWArrayList(){
    //capacity variable is set to default capacity
    capacity= INITIAL_CAPACITY;
    // theData E Array is assigned a new E Array with the object set at the size of the current capacity(which is equal to the Initial capacity)
    theData= (E[]) new Object[capacity];
}

    /**
     *  This is the first of the two types of add methods within the ArrayList general collection
     *  This add function appends anEntry to the end of the theData internal array and then increments the size
     *  The boolean add function must always return true
     * @param anEntry
     * @return
     */
    public boolean add(E anEntry){
   // if statement detects whether the array is full and then uses the reallocate method to create more capacity
    if(size==capacity)
    reallocate();
//appends a new entry to the internal theData array at position size, then increases the size by one
 theData[size]= anEntry;
 size++;
//must always return true
return true;
    }

    /**
     * This is the second of add type methods
     * This add method inputs a piece of data at a specified index within the internal theData array
     * @param index
     * @param anEntry
     */
    public void add(int index, E anEntry){
   //This add method relies on the position of insertion, so first check to see if the index is out of negative bounds or exceeds size
        if(index<0 || index>size){
       throw new ArrayIndexOutOfBoundsException(index);
   }
        //If the size is equal to the capacity, double the size of the internal theData array
        if(size==capacity){
       reallocate();
   }
   //shift data in elements from index to size-1
for(int i= size; i>index; i--){
    theData[i]= theData[i-1];
}
//append an entry to the specified index position and increase the size by one
theData[index]=anEntry;
size++;
}

    /**
     * The get method's main function is too retrieve an item from within the ArrayList
     * @param index
     * @return
     */
    public E get(int index){
    //We must check to ensure that we are not pulling from the out of bounds of the internal array
        if(index <0 || index>= size){
        throw new ArrayIndexOutOfBoundsException(index);
    }
//return the specified piece of information from index
        return theData[index];

}

    /**
     * The set method's main function is to set a new value  at an existing index and then to return the previous value
     * @param index
     * @param newValue
     * @return
     */
    public E set(int index, E newValue){
        // we must check that we are not setting a value that does not exist outside of the bounds
        if(index<0 || index>=size)
        throw new ArrayIndexOutOfBoundsException(index);
//the variable oldValue stores the current item within the position of the specified index
    E oldValue= theData[index];
//theData[index] now stores the newly "set" value
    theData[index]= newValue;
//the old value is returned
    return oldValue;
}

    /**
     * The remove function removes the specified data at the index then shifts the other indexes to fill that space
     * @param index
     * @return
     */
    public E remove(int index) {
    //we must check to see if we are trying to remove out of bounds
        if (index < 0 || index >= size) {
        throw new ArrayIndexOutOfBoundsException(index);

    }
   //the returnValue is set to the current data at the specified index
    E returnValue = theData[index];
    //the for loop then closes the gap created by storing the specified index
        for (int i = index + 1; i < size; i++) {
        theData[i - 1] = theData[i];
    }
    //size is decreased by one
        size--;
    //the returnValue is returned
        return returnValue;
}

    /** the reallocation method creates a new array twice the size of the current array and then copies the contents of the current array into the new one
     *
     */
    private void reallocate(){
    //capacity doubles
        capacity= 2*capacity;
    //theData is set to a new copy with its previous data and the new copy is double in size
        theData= Arrays.copyOf(theData, capacity);
}




}
