import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientHandlerTest {
    private int port = 7777;
    private Client echoClient;
    private ServerSocket serverSocket;
    private Server echoServer;

    private ArrayList<String> arrayListIn = new ArrayList<>();
    private ArrayListInput in;
    private ArrayListOutput out = new ArrayListOutput(new ArrayList<>());

    @BeforeEach
    public void setup() throws IOException {
        echoClient = new EchoClientSpy();
        serverSocket = new ServerSocket(port);
        Socket socket = new Socket("localhost", port);
        arrayListIn.add("Roger");
        arrayListIn.add("and");
        arrayListIn.add(".");
        arrayListIn.add("If this gets returned, it's all gone wrong");
        in = new ArrayListInput(arrayListIn);
        echoClient.start(socket, in, out);
    }

    @Test
    public void serverEchoesInputUntilFullStop() {
        echoServer = new EchoServerSpy(serverSocket, in, out);
        echoServer.run();
        assertEquals(3, out.getArrayList().size());
        assertEquals("Roger", out.getArrayList().get(0));
        assertEquals("and", out.getArrayList().get(1));
        assertEquals("Stopping.", out.getArrayList().get(2));
        assertEquals(3, ((EchoServerSpy) echoServer).respondCalledTimes);
    }

    @AfterEach
    public void tearDown() {
        out = new ArrayListOutput(new ArrayList<>());
        arrayListIn = new ArrayList<>();
        echoClient.stop();
    }
}
