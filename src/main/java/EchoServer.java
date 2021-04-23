import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {

    private ServerSocket serverSocket;
    private boolean running = true;

    public EchoServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void start() {
        System.out.println("Initializing...");
        while(running) {
            try {
                new ClientHandler(this.serverSocket.accept()).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
