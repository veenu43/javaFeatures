import java.util.ArrayList;

public class LocalVariables {
      
    public static void main(String[] args)
    {
        var list = new ArrayList<String>(); // infers ArrayList<String>
        var stream = list.stream();
    }
}
