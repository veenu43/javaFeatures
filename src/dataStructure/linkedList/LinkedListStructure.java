package dataStructure.linkedList;

import dataStructure.hashMap.HashMapStructure;

public class LinkedListStructure {
    LinkedListStructure.Node[] data;
    int size =16;

    public LinkedListStructure(int size) {
        this.data = new LinkedListStructure.Node[size];
        this.size = size;
    }

    static class Node<T> {
        T value;
        LinkedListStructure.Node<T> next;
        LinkedListStructure.Node<T> previous;

        Node(T value, LinkedListStructure.Node<T> next, LinkedListStructure.Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }


        public T getValue() {
            return value;
        }

        public LinkedListStructure.Node getNextNode() {
            return next;
        }
        public LinkedListStructure.Node getPreviousNode() {
            return previous;
        }
    }
}
