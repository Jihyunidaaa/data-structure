package edu.penn.jhkim;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class DoubleLinkedListTest {
    private DoubleLinkedList<Integer> linkedList;
    private LinkedList<Integer> ans;
    Random random;

    @Before
    public void init(){
        linkedList = new DoubleLinkedList<>();
        ans = new LinkedList<>();
        random = new Random();
    }

    @After
    public void tearDown(){
        linkedList = null;
        ans = null;
        random = null;
    }

    private void verify(int size){
        assertEquals(size, linkedList.size());
        assertEquals(size, ans.size());

        for(int i = 0; i < size; i++){
            assertEquals(ans.get(i), linkedList.get(i));
        }
    }

    @Test
    public void addTest(){
        final int ADD_ITERS = 10;

        for(int i = 0; i < ADD_ITERS; i++){
            linkedList.add(i);
            ans.add(i);
        }

        verify(ADD_ITERS);
    }

    @Test
    public void insertFrontTest(){
        final int INSERT_ITERS = 10;

        for(int i = INSERT_ITERS; i > 0; i--){
            linkedList.add(0, i);
            ans.add(0, i);
        }

        verify(INSERT_ITERS);
    }

    @Test
    public void insertRandomTest(){
        final int INSERT_ITERS = 10;

        linkedList.add(0);
        ans.add(0);

        for(int i = 1; i < INSERT_ITERS; i++){
            int randomIndex = random.nextInt(linkedList.size());
            linkedList.add(randomIndex, i);
            ans.add(randomIndex, i);
        }

        verify(INSERT_ITERS);
    }

    @Test
    public void removeFrontTest(){
        final int REMOVE_ITERS = 10;
        final int MAX_INT = 10000;

        for(int i = 0; i < REMOVE_ITERS; i++){
            int nextRandomInt = random.nextInt(MAX_INT);
            linkedList.add(nextRandomInt);
            ans.add(nextRandomInt);
        }

        verify(REMOVE_ITERS);

        for(int i = 0; i < REMOVE_ITERS; i++){
            linkedList.remove(0);
            ans.remove(0);
            verify(REMOVE_ITERS - i - 1);
        }
    }

    @Test
    public void removeRandomTest(){
        final int REMOVE_ITERS = 10;
        final int MAX_INT = 10000;

        for(int i = 0; i < REMOVE_ITERS; i++){
            int nextRandomInt = random.nextInt(MAX_INT);
            linkedList.add(nextRandomInt);
            ans.add(nextRandomInt);
        }

        verify(REMOVE_ITERS);

        for(int i = 0; i < REMOVE_ITERS; i++){
            int randomIndex = random.nextInt(REMOVE_ITERS - i);
            linkedList.remove(randomIndex);
            ans.remove(randomIndex);
            verify(REMOVE_ITERS - i - 1);
        }
    }
}
