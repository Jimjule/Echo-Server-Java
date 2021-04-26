import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class EchoClientTest {
    int port = 9999;
    ServerSocket serverSocket;
    Socket socket;
    Server clientHandler;

    ClientOutput out;
    ClientInput in;

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
        in = new BufferedInput(new BufferedReader(new InputStreamReader(socket.getInputStream())));
        out = new PrintWriterOutput(new PrintWriter(socket.getOutputStream()));
        client.start(socket, in, out);
        String response = client.sendMessage(message);
        assertEquals(response, message);
    }
}
