public class Solution {
    
    private static boolean oneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(Math.abs(m-n) > 1)
            return false;
        
        int i = 0, j = 0;
        int count = 0;
        while(i < m && j < n) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                count++;
                if(count > 1)
                    return false;
                if(m > n)
                    i++;
                else if(m < n)
                    j++;
                else {
                    i++;
                    j++;
                }
            }
        }
        if(i < m || j < n)
            count++;
        return count == 1;
    }

     public static void main(String []args){
        System.out.println(oneEditDistance("Hello", "Hllo"));
     }
}
