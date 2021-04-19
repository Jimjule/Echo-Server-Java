import java.net.Socket;

public class EchoServer {

    private Socket socket;

    public EchoServer(Socket socket) {
        this.socket = socket;
    }

    public String echo(String echo) {
        return echo;
    }

    public Socket getSocket() {
        return socket;
    }
}
