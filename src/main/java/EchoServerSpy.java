import java.net.ServerSocket;

public class EchoServerSpy implements Server {

    private ArrayListOutput out;
    private ArrayListInput in;
    private ServerSocket serverSocket;

    public int respondCalledTimes = 0;

    public EchoServerSpy(ServerSocket serverSocket, ArrayListInput in, ArrayListOutput out) {
        this.serverSocket = serverSocket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        for (int i = 0; i < in.getArrayList().size(); i++) {
            if (in.getArrayList().get(i).equals(".")) {
                respond("Stopping.");
                return;
            }
            respond((String) in.getArrayList().get(i));
        }
    }

    @Override
    public void respond(String response) {
        respondCalledTimes++;
        out.write(response);
    }
}
