package NO8;

public class Thread1 extends Thread{
    private Sender sender;
    private String packet;

    public Thread1(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void run() {
        while(true){
            sender.SendInfo(packet);
        }
    }
}
