package edu.penn.jhkim;

public class DynamicArray<T> {
    private Object[] data;
    private int size;
    private int capacity;

    public DynamicArray(){
        this(1);
    }

    public DynamicArray(int initialCapacity) {
        data = new Object[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }

    //Complexity: O(1) - Amortized
    public void add(T newElement){
        if(size == capacity){
            resize();
        }
        data[size++] = newElement;
    }

    //Complexity: O(n)
    public void add(int index, T newElement){
        if(index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if(size == capacity){
            resize();
        }

        for(int i = size - 1; i >= index; i--){
            data[i+1]= data[i];
        }
        data[index] = newElement;
        size++;
    }

    //Complexity: O(1)
    public T get(int index){
        if(index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }

    //Complexity: O(1)
    public int size(){
        return size;
    }

    //Complexity: O(n)
    public void remove(int index){
        if(index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
    }

    private void resize(){
        Object[] tmp = data;
        capacity *= 2;
        data = new Object[capacity];

        for(int i = 0; i < size; i++){
            data[i] = tmp[i];
        }
    }
}
