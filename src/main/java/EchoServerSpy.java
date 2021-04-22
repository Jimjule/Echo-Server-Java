import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class EchoServerSpy implements Server {

    private Socket clientSocket;
    private ArrayList<String> out;
    private ArrayList<String> in;
    private ServerSocket serverSocket;

    public int respondCalledTimes = 0;

    public EchoServerSpy(ServerSocket serverSocket, ArrayList<String> in, ArrayList<String> out) {
        this.serverSocket = serverSocket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        for (String message: in) {
            if (message.equals(".")) {
                respond("Stopping.");
                return;
            }
            respond(message);
        }
    }

    @Override
    public void respond(String response) {
        respondCalledTimes++;
        out.add(response);
    }
}
