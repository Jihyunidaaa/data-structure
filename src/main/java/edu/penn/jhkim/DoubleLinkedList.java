package edu.penn.jhkim;

public class DoubleLinkedList<T> {
    Node head;
    Node tail;
    int size;

    public class Node{
        private T data;
        private Node next;
        private Node prev;

        public Node(T data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedList(){
        head = new Node(null);
        tail = new Node(null);

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    public void add(T newElement){
        Node newNode = new Node(newElement);

        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;

        newNode.next = tail;
        tail.prev = newNode;

        size++;
    }

    private Node nthNode(int index){
        if(index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node cur = head;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }

        return cur;
    }

    public void add(int index, T newElement){
        Node prev = nthNode(index - 1);
        Node next = prev.next;

        Node newNode = new Node(newElement);

        prev.next = newNode;
        newNode.prev = prev;

        newNode.next = next;
        next.prev = newNode;

        size++;
    }

    public T get(int index){
        Node node = nthNode(index);
        return node.data;
    }

    public int size(){
        return size;
    }

    public void remove(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node prev = nthNode(index - 1);
        Node next = prev.next.next;

        prev.next = next;
        next.prev = prev;

        size--;
    }
}
