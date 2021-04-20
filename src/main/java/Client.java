import java.net.Socket;

public interface Client {
    void start(Socket socket);

    String sendMessage(String message);

    void stop();
}
