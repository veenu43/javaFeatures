package dataStructure.stack;

public class StackPractise {

    Object[] dataArray;
    int size;
    int position;

    public StackPractise(int size) {
        this.size = size;
        this.dataArray = new Object[size];
        this.position=0;
    }

    public boolean push(Object data){
        if(position >= size){
            return false;
        }
        dataArray[position++] = data;
        return true;
    }

    public Object pop(){
        if(position < 1){
            return null;
        }
        return dataArray[--position];
    }
}
