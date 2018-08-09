import java.util.*;
public class Solution {

    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> hmap = new HashMap<>();
        hmap.put('0', '0');
        hmap.put('1', '1');
        hmap.put('6', '9');
        hmap.put('8', '8');
        hmap.put('9', '6');
        for(int i = 0, j = num.length()-1; i <= j; i++, j--) {
            if(!hmap.containsKey(num.charAt(i)) || !hmap.containsKey(num.charAt(j)))
                return false;
            if(hmap.get(num.charAt(i)) != num.charAt(j))
                return false;
        }
        return true;
    }

    public static List<String> findStobrogrammatic(int n) {
        HashMap<Character, Character> hmap = new HashMap<>();
        hmap.put('0', '0');
        hmap.put('1', '1');
        hmap.put('6', '9');
        hmap.put('8', '8');
        hmap.put('9', '6');
        return generateStobro(n, hmap, true);
    }
    
    public static List<String> generateStobro(int n, HashMap<Character, Character> hmap, boolean last) {
        List<String> res = new ArrayList<>();
        if(n == 0) {
            res.add("");
            return res;
        }
        
        if(n == 1) {
            res.add("1");
            res.add("8");
            res.add("0");
            return res;
        }
        
        List<String> temp = generateStobro(n-2, hmap, false);
        for(String t: temp) {
            for(char key: hmap.keySet()) {
                if(key == '0' && last)
                    continue;
                res.add(key+t+hmap.get(key));
            }
                
        }
        return res;
    }
    
    public static int findStobrogrammaticInRange(String lower, String upper) {
        int m = lower.length();
        int n = upper.length();
        List<String> res = new ArrayList<>();
        List<String> temp = findStobrogrammatic(m);
        for(String t: temp) {
            if(t.compareTo(lower)<0)
                continue;
            res.add(t);
        }
         for(int i = m+1; i < n; i++)
            res.addAll(findStobrogrammatic(i));
        if(m != n) {
            temp = findStobrogrammatic(n);
            for(String t: temp) {
                if(t.compareTo(upper)>0)
                    continue;
                res.add(t);
            }
        }
        
        return res.size();
    }
     public static void main(String []args){
        List<String> list = findStobrogrammatic(3);
        for(String t: list)
            System.out.println(t);
        System.out.println(findStobrogrammaticInRange("666", "888"));
     }
}
