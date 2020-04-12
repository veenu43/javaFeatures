package dataStructure.hashMap;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapStructureTest {

    @Test
    public void test(){
        HashMapStructure<String,String> map = new HashMapStructure<>();
        map.put("Vinit1","Vinit1");
        map.put("Vinit2","Vinit1");
        map.put("Vinit3","Vinit3");
        map.put("Vinit1","Vinit2");
        System.out.println("Key :"+"Vinit1"+" Value: "+map.get("Vinit1"));
        System.out.println("Key :"+"Vinit2"+" Value: "+map.get("Vinit2"));
        System.out.println("Key :"+"Vinit3"+" Value: "+map.get("Vinit3"));
        System.out.println("Key :"+"Vinit4"+" Value: "+map.get("Vinit4"));
    }

}