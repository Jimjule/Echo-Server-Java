import java.net.Socket;

public class Main {

    public static void main(String args[]) {
        Socket socket = new Socket();
        EchoServer echoServer = new EchoServer(socket);
        String echoString = echoServer.echo("Echo!");
        System.out.println(echoString);
    }
}
