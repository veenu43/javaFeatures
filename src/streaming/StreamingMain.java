package streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamingMain {

    public static void main(String[] str){
        List<Person> personList = new ArrayList<>();
        for(int count=0;count < 1000;count++){
            personList.add(new Person("Name_"+count,count));
        }

       List<Person> filteredList =  personList.stream().filter(person -> person.age>500).collect(Collectors.toList());
       System.out.print("Size; "+filteredList.size());

       Person firstperson =  personList.stream().filter(person -> person.age>500).findFirst().orElse(null);
       System.out.print("Age : "+firstperson.age);

       List<String> nameList =  personList.stream().map(Person:: getName).collect(Collectors.toList());
       System.out.print("nameList : "+nameList);

        personList.stream().forEach(person ->
                System.out.println("name : "+person)
        );

    }
}
