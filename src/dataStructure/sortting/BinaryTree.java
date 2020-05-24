package dataStructure.sortting;

public class BinaryTree<T> {
    Node rootNode;

    static class Node {
        Node leftNode;
        Node rightNode;
        Integer value;

        public Node(Node leftNode, Node rightNode, Integer value) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.value = value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public Integer getValue() {
            return value;
        }

    }


    public void add(Integer value) {
        rootNode = addRecursive(rootNode, value);
    }

    protected Node addRecursive(Node currentNode, Integer value) {
        if (currentNode == null) {
            return new Node(null, null, value);
        }

        if (currentNode.value > value) {
            currentNode.leftNode = addRecursive(currentNode.leftNode, value);
        } else if (currentNode.value < value) {
            currentNode.rightNode = addRecursive(currentNode.rightNode, value);
        }

        return currentNode;
    }

    protected boolean containsNodeRecursive(Node curretNode, Integer value) {
        if (curretNode == null) {
            return false;
        }
        if (value == curretNode.value) {
            return true;
        }
        return value < curretNode.value ? containsNodeRecursive(curretNode.leftNode, value) : containsNodeRecursive(curretNode.rightNode, value);
    }

    public boolean contain(Integer value) {
        return containsNodeRecursive(rootNode, value);
    }
}
