import java.io.*;
import java.net.Socket;

public class EchoClient implements Client {
    private Socket clientSocket;
    private ClientInput in;
    private ClientOutput out;

    @Override
    public void start(Socket socket, ClientInput in, ClientOutput out) {
        clientSocket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public String sendMessage(String message) {
        String response = null;
        try {
            out.write(message);
            response = in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public void stop() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
