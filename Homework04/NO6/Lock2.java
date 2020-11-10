package YuchenZhao.NO6;

public class Lock2{
    private boolean isLocked = false;
    
    public synchronized void lock() throws InterruptedException{
        while(isLocked){    
            wait();
        }
        isLocked = true;
    }
    
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}