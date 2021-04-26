import java.util.ArrayList;

public class ArrayListInput implements ClientInput {
    private ArrayList<String> in;
    int index = 0;

    ArrayListInput(ArrayList<String> in) {
        this.in = in;
    }
    
    @Override
    public String read() {
        String input = null;
        try {
            input = in.get(index);
            index++;
        } catch (IndexOutOfBoundsException err) {
            err.printStackTrace();
        }
        return input;
    }

    public ArrayList getArrayList() {
        return in;
    }
}
