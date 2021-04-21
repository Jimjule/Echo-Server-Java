import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EchoServerTest {
    private int port = 7777;
    private Client echoClient;
    private ServerSocket serverSocket;
    private Server echoServer;

    private ArrayList<String> out = new ArrayList<>();
    private ArrayList<String> in = new ArrayList<>();



    @BeforeEach
    public void setup() throws IOException {
        echoClient = new EchoClientSpy();
        serverSocket = new ServerSocket(port);
        Socket socket = new Socket("localhost", port);
        echoClient.start(socket);
        in.add(echoClient.sendMessage("Roger"));
        in.add(echoClient.sendMessage("and"));
        in.add(echoClient.sendMessage("."));
        in.add(echoClient.sendMessage("If you can see this, it's all gone wrong"));
    }

    @Test
    public void serverEchoesInputUntilFullStop() throws IOException {
        echoServer = new EchoServerSpy(serverSocket, in, out);
        echoServer.start();
        assertEquals("Roger", out.get(0));
        assertEquals("and", out.get(1));
        assertEquals("Stopping.", out.get(2));
        assertEquals(3, out.size());
        assertEquals(3, ((EchoServerSpy) echoServer).respondCalledTimes);
    }

    @AfterEach
    public void tearDown() {
        out = new ArrayList<>();
        in = new ArrayList<>();
        echoClient.stop();
        try {
            echoServer.getServerSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}