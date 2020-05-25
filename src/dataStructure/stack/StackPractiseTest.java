package dataStructure.stack;

import dataStructure.queue.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackPractiseTest {

    StackPractise stack;
    Queue<String> queueTest;

    @Before
    public void setUp() {
        stack = new StackPractise(10);
        queueTest = new Queue<>(10, true);
    }

    @Test
    public void test() {
        stack.push("Vinit1");
        stack.push("Vinit2");
        stack.push("Vinit3");
        stack.push("Vinit4");
        Assert.assertEquals("Vinit4", stack.pop());
        Assert.assertEquals("Vinit3", stack.pop());
        stack.push("Vinit5");
        stack.push("Vinit6");
        Assert.assertEquals("Vinit6", stack.pop());
        Assert.assertEquals("Vinit5", stack.pop());
        Assert.assertEquals("Vinit2", stack.pop());
        Assert.assertEquals("Vinit1", stack.pop());
        Assert.assertEquals(null, stack.pop());
    }
}