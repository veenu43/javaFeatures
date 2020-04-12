package dataStructure.hashMap;

import java.util.HashMap;
import java.util.Map;

public class TestHashAndEquals {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] arg){
        Person person = new Person("Vinit",23);
        System.out.println("Hash: "+person.hashCode());
        System.out.println("toString: "+person.toString());
        int hascode =9869879;
        int size = 16;
        int bucket = hascode & (size-1);
        System.out.println("Bucket: "+bucket);
        Map map =  new HashMap();

        System.out.println("table Size: "+tableSizeFor(2000));
    }

    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
