import java.util.*;
public class Solution {
    
    private static boolean wordPatternMatch(String pattern, String str) {
       if(pattern.length() == 0 && str.length() == 0)
        return true;
       if(pattern.length() == 0)
        return false;
       HashMap<Character, String> map = new HashMap<Character, String>();
       HashSet<String> set = new HashSet<>();
       return backtrack(pattern, str, 0, 0, map, set);
    }
    
    private static boolean backtrack(String pattern, String str, int i, int j, HashMap<Character, String> hmap, HashSet<String> set) {
        if(i == pattern.length() && j == str.length())
            return true;
        if(i >= pattern.length() || j >= str.length())
            return false;
        
        char c = pattern.charAt(i);
        for(int k = j+1; k <= str.length(); k++) {
            String s = str.substring(j, k);
            if(!hmap.containsKey(c) && !set.contains(s)) {
                hmap.put(c, s);
                set.add(s);
                if(backtrack(pattern, str, i+1, k, hmap, set))
                    return true;
                hmap.remove(c);
                set.remove(s);
            } else if(hmap.containsKey(c) && hmap.get(c).equals(s)) {
                if(backtrack(pattern, str, i+1, k, hmap, set))
                    return true;
            }
        }
        return false;
    }
    
     public static void main(String []args) {
       System.out.println(wordPatternMatch("aabb", "xyzabcxzyabc"));
     }
}
