import java.io.BufferedReader;
import java.io.IOException;

public class BufferedInput implements ClientInput {
    private BufferedReader in;

    BufferedInput(BufferedReader in) {
        this.in = in;
    }

    @Override
    public String read() throws IOException {
        return in.readLine();
    }
}
