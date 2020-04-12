package multithreading.prodConProb;

public class VolatileData {

    volatile boolean isActive= true;

    public void disableActive(){
        isActive =false;
    }

    public void enableActive(){
        isActive =true;
    }

    public boolean isActive() {
        return isActive;
    }
}
