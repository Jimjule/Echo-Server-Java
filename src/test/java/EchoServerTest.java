import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.*;

class EchoServerTest {
    @Test
    public void echoServerTakesServerSocketTest() throws IOException {
        int port = 4567;
        ServerSocket serverSocket = new ServerSocket(port);
        EchoServer echoServer = new EchoServer(serverSocket);
        assertTrue(echoServer.getServerSocket().isBound());
        echoServer.closeAll();
    }
}
