package dataStructure.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueuePractiseTest {
    QueuePractise queue;
    Queue<String> queueTest;

    @Before
    public void setUp() {
        queue = new QueuePractise(10);
        queueTest = new Queue<>(10,true);
    }

    @Test
    public void test() {
        queue.offer("Vinit1");
        queue.offer("Vinit2");
        queue.offer("Vinit3");
        queue.offer("Vinit4");
        Assert.assertEquals("Vinit1",queue.poll());
        Assert.assertEquals("Vinit2",queue.poll());
        queue.offer("Vinit5");
        queue.offer("Vinit6");
        Assert.assertEquals("Vinit3",queue.poll());
        Assert.assertEquals("Vinit4",queue.poll());
        Assert.assertEquals("Vinit5",queue.poll());
        Assert.assertEquals("Vinit6",queue.poll());
    }

    @Test
    public void testOrg() {
        queueTest.enqueue("Vinit1");
        queueTest.enqueue("Vinit2");
        queueTest.enqueue("Vinit3");
        queueTest.enqueue("Vinit4");
        Assert.assertEquals("Vinit1",queueTest.peek());
        Assert.assertEquals("Vinit2",queueTest.peek());
        queueTest.enqueue("Vinit5");
        queueTest.enqueue("Vinit6");
        Assert.assertEquals("Vinit3",queueTest.peek());
        Assert.assertEquals("Vinit4",queueTest.peek());
        Assert.assertEquals("Vinit5",queueTest.peek());
        Assert.assertEquals("Vinit6",queueTest.peek());
    }


}