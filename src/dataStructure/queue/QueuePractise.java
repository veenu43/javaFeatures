package dataStructure.queue;

public class QueuePractise {
    Object[]  dataArray;
    int size;
    int offerPosition;
    int peekPosition;

    public QueuePractise(int size) {
        this.size = size;
        this.offerPosition = size-1;
        this.peekPosition = size-1;
        dataArray = new Object[size];
    }

    public boolean offer(Object data){
        if(offerPosition <1){
            return false;
        }
        dataArray[offerPosition--] = data;
        return true;
    }

    public Object poll(){
        if(peekPosition <1 || peekPosition < offerPosition){
            return null;
        }
        return dataArray[peekPosition--];
    }

}
