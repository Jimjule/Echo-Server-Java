import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer implements Server {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private ServerSocket serverSocket;

    public EchoServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void start() {
        System.out.println("Initializing...");
        try {
            clientSocket = this.serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String input;
            while((input = in.readLine()) != null) {
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
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    @Override
    public void respond(String response) {
        out.println(response);
    }
}
