package collections;
import java.util.HashMap;
import java.util.Map;

public class MapHashClass {


    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        
        map.put(5, "Tether");
        map.put(8, "Lumens");
        map.put(6, "Bitcoin");
        map.put(4, "Litecoin"); // Overwritten
        map.put(2, "Atom");
        map.put(4, "Ethereum");
        
        String text = map.get(6);
        
        System.out.println(text);
        System.out.println('\n');
        
        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            
            System.out.println(key + ": " + value);
        }
        
    }

}
// Six
// 2: Two
// 4: Four
// 5: Five
// 6: Six
// 8: Eight
 