package dataStructure.stack;

import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> dataList;
    Object[] dataArray;
    int position;
    int size;
    boolean isArrayImplementation = true;

    public Stack(int size, boolean isArrayImplementation) {
        dataList = new ArrayList<>(size);
        dataArray = new Object[size];
        this.size = size;
        position = -1;
        this.isArrayImplementation = isArrayImplementation;
    }

    public boolean push(T data) {
        if (isArrayImplementation) {
            return pushArrays(data);
        }
        return pushList(data);
    }

    private boolean pushList(T data) {
        position++;
        return dataList.add(data);
    }

    private boolean pushArrays(T data) {
        if (position >= size) {
            return false;
        }
        dataArray[++position] = data;
        return true;
    }

    public T pop() {
        if (isArrayImplementation) {
            return popArray();
        }
        return popList();
    }

    private T popArray() {
        if (position < 0) {
            return null;
        }
        T data = (T) dataArray[position--];

        return data;
    }

    private T popList() {
        T data = dataList.get(position--);
        dataList.remove(data);
        return data;
    }
}
