class Solution {
    public boolean isMatch(String s, String p) {
        return check(s, p, 0, 0);
    }
    boolean check(String s, String p, int sindex, int pindex) {
        if(pindex == p.length())
            return sindex == s.length();
        boolean firstmatch = (sindex < s.length()) && (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.');
        if(pindex < p.length()-1 && p.charAt(pindex+1)=='*')
            return check(s, p, sindex, pindex+2) || (firstmatch && check(s, p, sindex+1, pindex));
        else
            return firstmatch && check(s, p, sindex+1, pindex+1);
    }
}
