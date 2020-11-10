package NO8;

public class Sender {

	private Data data;

    public Sender(Data data) {
        this.data = data;
    }
    
    public void SendInfo(String packet){
        data.send(packet);
    }

}
