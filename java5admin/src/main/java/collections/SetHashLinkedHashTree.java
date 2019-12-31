package collections;
 
import java.util.Set;
//import java.util.HashSet; 
//import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetHashLinkedHashTree {

    public static void main(String[] args) {

        // HashSet does not retain order.
//        Set<String> setHashSet = new HashSet<String>();

        // LinkedHashSet remembers the order you added items in
//        Set<String> setLinkedHashSet= new LinkedHashSet<String>();

        // TreeSet sorts in natural order 
        Set<String> setTreeSet = new TreeSet<String>();

        if (setTreeSet.isEmpty()) {
            System.out.println("Set is empty at start");
        }

        setTreeSet.add("dog");
        setTreeSet.add("cat");
        setTreeSet.add("mouse");
        setTreeSet.add("snake");
        setTreeSet.add("bear");

        if (setTreeSet.isEmpty()) {
            System.out.println("Set is empty after adding (no!)");
        }

        // Adding duplicate items does nothing.
        setTreeSet.add("mouse");

        System.out.println(setTreeSet);

        // ///////// Iteration ////////////////

        for (String element : setTreeSet) {
            System.out.println(element);
        }

        // ////////// Does set contains a given item? //////////
        if (setTreeSet.contains("aardvark")) {
            System.out.println("Contains aardvark");
        }

        if (setTreeSet.contains("cat")) {
            System.out.println("Contains cat");
        }

        /// setTreeSet2 contains some common elements with setTreeSet, and some new

        Set<String> setTreeSet2 = new TreeSet<String>();

        setTreeSet2.add("dog");
        setTreeSet2.add("cat");
        setTreeSet2.add("giraffe");
        setTreeSet2.add("monkey");
        setTreeSet2.add("ant");
        
        ////////////// Intersection ///////////////////
        
        Set<String> intersection = new TreeSet<String>(setTreeSet);
        
        intersection.retainAll(setTreeSet2);
        
        System.out.println(intersection);
        
        ////////////// Difference /////////////////////////
        
        Set<String> difference = new TreeSet<String>(setTreeSet2);
        
        difference.removeAll(setTreeSet);
        System.out.println(difference);
    }

}
// Set is empty at start
// [bear, cat, dog, mouse, snake]
// bear
// cat
// dog
// mouse
// snake
// Contains cat
// [cat, dog]
// [giraffe, ant, monkey]

 