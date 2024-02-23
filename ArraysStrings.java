import java.util.HashMap;
import java.util.Map;

public class ArraysStrings {
    /* Implement an Algo to determine if a string has all unique characters
     * Assuming ASCII - how do I account for Unicode?
     * 
     */
    // O(N) Time O(1) Space - since we use a bit vector that won't grow beyond the size of 25 char ints - rewrite
    public boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
    
    // O(n) space - the size of the string to Map
    public boolean isUniqueCharsMap(String str) {
        Map<Character, Boolean> hashMap = new HashMap<Character, Boolean>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (hashMap.containsKey(c)) {
                return false;
            }
            hashMap.put(c, true);
        }
        return true;
    }

    /* Check Permutation: Given two Strngs, determine if one is a permutation of the other
     * Is it case sensitive? Whitespace significant? Assume yes.
     * "god___" !== "dog"
     * Permutation: Same Characters - diff order
     */
    // Sort the strings and then check if permutation
    String sort(String s) {
        char[] content = s.toCharArray(); // O(n) time and space
        java.util.Arrays.sort(content); // O(nlogn) t O(logn) space
        return new String(content);  // O(n) T & S
    }

    boolean permutation(String s, String t) {
        if (s.length() != t.length()) { return false; }

        return sort(s).equals(sort(t)); // O(n) space for each char array - but space could be considered reclaimed before the next sort call
        // But the space for both strings exist for the comparison
        // O(n) time for equals
    } // Overall O(nlogn) time O(n) space

    

    public static void main(String[] args) {
        ArraysStrings testBby = new ArraysStrings();
        String uniqueString = "abc";
        String uniqueString2 = "gfedcba";
        boolean uniqueCharVector = testBby.isUniqueChars(uniqueString);
        // boolean uniqueCharMap = testBby.isUniqueCharsMap(uniqueString);
        System.out.printf("The test was: %1$s, and %2$s", uniqueCharVector);

        boolean permutation = testBby.permutation(uniqueString, uniqueString2);
        System.out.printf("Permutation test: %1$s", permutation);

    }
}