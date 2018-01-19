import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(1,"hell");
        hmap.put(2, "huck");
        hmap.put(3, "lol");
        /*Set set = hmap.entrySet();*/
        Iterator iterator = hmap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.println(mentry.getValue());
        }
        System.out.println("----------------------------");
        System.out.println(hmap.get(3));
    }
}
