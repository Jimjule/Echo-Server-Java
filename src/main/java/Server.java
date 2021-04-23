import java.io.IOException;

public interface Server {
    void run();

    void respond(String response);
}
