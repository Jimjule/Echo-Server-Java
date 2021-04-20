import java.io.*;
import java.net.Socket;

public class EchoClient implements Client {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    @Override
    public void start(Socket socket) {
        try {
            clientSocket = socket;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String sendMessage(String message) {
        out.println(message);
        String response = null;
        try {
            response = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
