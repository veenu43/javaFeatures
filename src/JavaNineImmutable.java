import java.util.List;
import java.util.Map;

public class JavaNineImmutable {


    public static void main(String[] args)
    {
        List emptyLIst = List.of();
        List nameList = List.of("Vinit","Kanak");
        nameList.stream().forEach(name->{
            System.out.println(name);
        });

        Map  emptyMap = Map.of();
        Map nameMap = Map.of(1,"One",2,"Two");
        nameMap.forEach((key,value)-> {
            System.out.println("Key :"+key+ " Value: "+ value);
        });


    }

}
