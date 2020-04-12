package dataStructure.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

public class StackTest {

    Stack<String> stack;
    int size = 1000000;

    @Before
    public void setUp(){

    }

    @Test
    public void test(){
        testType(true);
        testType(false);
    }

    public void testType(boolean flag){
        long startInMilliSeconds = Instant.now().toEpochMilli();
        stack = new Stack<>(size,flag);
        String name = "name";
        for(int i=0; i<size;i++){
            stack.push(name+i);
        }
        long endPushInMilliSeconds = Instant.now().toEpochMilli();
        for(int j=size-1; j>0;j--){
            Assert.assertEquals(name+j,stack.pop());
        }
        long endPopMilliSeconds = Instant.now().toEpochMilli();

        System.out.println("TIme taken to Push in milliseconds"+ (endPushInMilliSeconds-startInMilliSeconds));
        System.out.println("TIme taken to Pop in milliseconds"+ (endPopMilliSeconds-endPushInMilliSeconds));
        System.out.println("TIme taken overall operations milliseconds"+ (endPopMilliSeconds-startInMilliSeconds));
    }


}