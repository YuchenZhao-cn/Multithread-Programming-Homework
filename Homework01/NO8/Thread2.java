package NO8;

public class Thread2 extends Thread{
    private Receiver receiver;

    public Thread2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        while(true){
            receiver.ReceiveInfo();
        }
    }

}
