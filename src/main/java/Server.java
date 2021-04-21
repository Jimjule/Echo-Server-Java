import java.net.ServerSocket;

public interface Server {
    void start();

    ServerSocket getServerSocket();

    void respond(String response);
}
