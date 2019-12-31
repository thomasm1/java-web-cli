public class ExceptionsRunTime.java {

    public static void main(String[] args) {
        
        // Null pointer exception...
        String text = null;
        
        System.out.println(text.length());
        
        // Math exception ... 
        int value = 7/0;

        // RuntimeExceptions: ArrayIndexOutOfBoundsException
        String[] texts = { "one", "two", "three" };

        try {
            System.out.println(texts[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }
}