import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class EchoServerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void echoServerSetupTest() {
        Socket socket = new Socket();
        EchoServer echoServer = new EchoServer(socket);
        assertEquals(echoServer.echo("Hello"), "Hello");
    }

    @Test
    public void echoServerTakesSocketTest() {
        Socket socket = new Socket();
        EchoServer echoServer = new EchoServer(socket);
        assertFalse(echoServer.getSocket().isBound());
    }
}
