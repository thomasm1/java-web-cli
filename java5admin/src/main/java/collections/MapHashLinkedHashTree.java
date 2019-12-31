package collections;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapHashLinkedHashTree {

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<Integer, String>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
        Map<Integer, String> treeMap = new TreeMap<Integer, String>();
        
        myTreeMap(treeMap);
    }
    
    public static void myTreeMap(Map<Integer, String> map) {
        map.put(9, "fox");
        map.put(4, "cat");
        map.put(8, "dog");
        map.put(1, "giraffe");
        map.put(0, "swan");
        map.put(15, "bear");
        map.put(6, "snake");
        
        for(Integer key: map.keySet()) {
            String value = map.get(key);
            
            System.out.println(key + ": " + value);
        }
    }
    
}
// 0: swan
// 1: giraffe
// 4: cat
// 6: snake
// 8: dog
// 9: fox
// 15: bear


