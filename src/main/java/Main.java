public class Main {

    public static void main(String args[]) {
        EchoServer echoServer = new EchoServer();
        String echoString = echoServer.echo("Echo!");
        System.out.println(echoString);
    }
}
