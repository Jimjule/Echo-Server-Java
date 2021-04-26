import java.io.PrintWriter;

public class PrintWriterOutput implements ClientOutput {
    private PrintWriter out;
    int index = 0;

    PrintWriterOutput(PrintWriter out) {
        this.out = out;
    }
    
    @Override
    public void write(String output) {
        try {
            out.println(output);
        } catch (IndexOutOfBoundsException err){
            err.getStackTrace();
        }
    }

    public PrintWriter getPrintWriter() {
        return out;
    }
}
