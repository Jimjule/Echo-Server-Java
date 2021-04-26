import java.util.ArrayList;

public class ArrayListOutput implements ClientOutput {
    private ArrayList<String> out;

    ArrayListOutput(ArrayList<String> out) {
        this.out = out;
    }
    
    public void write(String output) {
        try {
            out.add(output);
        } catch (IndexOutOfBoundsException err){
            err.getStackTrace();
        }
    }

    public ArrayList<String> getArrayList() {
        return out;
    }
}
