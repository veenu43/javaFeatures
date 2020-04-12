package dataStructure.queue;

import java.util.ArrayList;

public class Queue<T> {

    ArrayList<T> dataList;
    Object[] dataArray;
    int position;
    int size;
    boolean isArrayImplementation = true;

    public Queue(int size, boolean isArrayImplementation) {
        dataList = new ArrayList<>(size);
        dataArray = new Object[size];
        this.size = size;
        position = size ;
        this.isArrayImplementation = isArrayImplementation;
    }

    public boolean enqueue(T data) {
        if (isArrayImplementation) {
            return enqueueArrays(data);
        }
        return enqueueList(data);
    }

    private boolean enqueueList(T data) {
        position--;
        return dataList.add(data);
    }

    private boolean enqueueArrays(T data) {
        if (position >= size) {
            return false;
        }
        dataArray[--position] = data;
        return true;
    }

    public T peek() {
        if (isArrayImplementation) {
            return peekArray();
        }
        return peekList();
    }

    private T peekArray() {
        if (position < size) {
            return null;
        }
        T data = (T) dataArray[position++];

        return data;
    }

    private T peekList() {
        T data = dataList.get(position++);
        dataList.remove(data);
        return data;
    }
}
