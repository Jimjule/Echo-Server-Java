import java.net.Socket;

public interface Client {
    void start(Socket socket, ClientInput in, ClientOutput out);

    String sendMessage(String message);

    void stop();
}
