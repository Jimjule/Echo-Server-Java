import java.net.Socket;

public class EchoClientSpy implements Client {
    public boolean startIsCalled = false;
    public boolean sendMessageIsCalled = false;
    public boolean stopIsCalled = false;

    @Override
    public void start(Socket socket) {
        startIsCalled = true;
    }

    @Override
    public String sendMessage(String message) {
        sendMessageIsCalled = true;
        return message;
    }

    @Override
    public void stop() {
        stopIsCalled = true;
    }
}
