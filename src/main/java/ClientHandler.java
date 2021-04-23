import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread implements Server {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String input;
            while ((input = in.readLine()) != null) {
                if (input.equals(".")) {
                    respond("Stopping.");
                    return;
                }
                respond(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void respond(String response) {
        out.println(response);
    }
}
