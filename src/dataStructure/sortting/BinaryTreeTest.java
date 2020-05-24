package dataStructure.sortting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
    BinaryTree tree;
    Integer[] values;

    @Before
    public void setUp(){
        values = new Integer[]{10,5,3,6,8,4,9};
        tree=  createBinaryTree();
    }
    @Test
    public void validateAddition(){
        for(Integer value : values){
            Assert.assertTrue(tree.contain(value));
        }
    }

    private BinaryTree createBinaryTree() {
        BinaryTree tree = new BinaryTree();
        for(Integer value : values){
            tree.add(value);
        }
        return tree;
    }
}
