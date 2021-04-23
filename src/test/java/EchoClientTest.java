import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class EchoClientTest {
    int port = 9999;
    ServerSocket serverSocket;
    Socket socket;
    Server clientHandler;

    @BeforeEach
    public void setup() throws IOException {
        serverSocket = new ServerSocket(port);
        clientHandler = new ClientHandler(socket);
    }

    @Test
    public void clientMessagesServerAndGetsResponse() throws IOException {
        String message = "Gid moaning!";
        Socket socket = new Socket("localhost", port);
        Client client = new EchoClientSpy();
        client.start(socket);
        String response = client.sendMessage(message);
        assertEquals(response, message);
    }
}
