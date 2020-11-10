package NO8;

public class Receiver {
	private Data data;

    public Receiver(Data data) {
        this.data = data;
    }
    
    public void ReceiveInfo(){
        data.receive();
    }

}
