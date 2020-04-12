package dataStructure.hashMap;

import java.util.Map;
import java.util.Optional;

public class HashMapStructure<K, V> {

    Node[] data;
    int size = 16;

    public HashMapStructure() {
        initialize();
    }

    public HashMapStructure(int inputSize) {
        this.size = inputSize;
        initialize();
    }

    private void initialize() {
        data = new Node[size];
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        final int hash;
        HashMapStructure.Node<K, V> next;

        Node(int hash, K key, V value, HashMapStructure.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            value = newValue;
            return value;
        }

        public Node getNextNode() {
            return next;
        }
    }


    public V put(K key, V value) {
        int hascode = hash(key);
        int bucketPosition = bucket(hascode);
        Node existingNode = data[bucketPosition];
        Node newNode;
        if (existingNode == null) {
            newNode = new Node(hash(key), key, value, null);
            data[bucketPosition] = newNode;
        } else {
            if (!checkExistingKey(key, value, existingNode)) {
                newNode = new Node(hash(key), key, value, existingNode);
                data[bucketPosition] = newNode;
            }
        }
        return value;
    }

    public V get(K key) {
        int hascode = hash(key);
        int bucketPosition = bucket(hascode);
        Node<K, V> bucketNode = data[bucketPosition];
        Optional<Node<K, V>> existingNode = getExistingNode(key, bucketNode);
        if (existingNode.isPresent()) {
            return existingNode.get().getValue();
        }
        return null;
    }

    private boolean checkExistingKey(K key, V value, Node bucketNode) {
        Optional<Node<K, V>> existingNode = getExistingNode(key, bucketNode);
        if (existingNode.isPresent()) {
            existingNode.get().setValue(value);
            return true;
        }
        return false;
    }

    private Optional<Node<K, V>> getExistingNode(K key, Node bucketNode) {
        Node<K, V> existingNode = bucketNode;
        while (existingNode != null) {
            if (existingNode.getKey().equals(key)) {
                return Optional.of(existingNode);
            }
            existingNode = existingNode.getNextNode();
        }
        return Optional.empty();
    }

    private int hash(K key) {
        return key.hashCode();
    }

    private int bucket(int hashcode) {
        int bucket = hashcode & (size - 1);
        return bucket;
    }
}
