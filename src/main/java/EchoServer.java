import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {

    private final ServerSocket serverSocket;

    public EchoServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public String echo(String echo) {
        return echo;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void closeAll() throws IOException {
        this.serverSocket.close();
    }
}
