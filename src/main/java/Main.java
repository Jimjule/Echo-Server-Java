import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String args[]) throws IOException {
        int port = 4567;
        ServerSocket serverSocket = new ServerSocket(port);
        EchoServer echoServer = new EchoServer(serverSocket);
        echoServer.start();
    }
}
