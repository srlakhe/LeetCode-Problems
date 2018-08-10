import java.util.*;
public class Solution {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int start = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0)+1);
            if(hmap.size() > 2) {
                while(hmap.size() > 2) {
                    hmap.put(s.charAt(start), hmap.get(s.charAt(start))-1);
                    if(hmap.get(s.charAt(start)) == 0)
                        hmap.remove(s.charAt(start));
                    start++;
                }
            }
            len = Math.max(len, i-start+1);
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("aba"));
    }
}
