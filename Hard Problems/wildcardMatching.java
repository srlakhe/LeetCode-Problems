class Solution {
    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0;
        int star = -1, match = 0;
        while(si < s.length()) {
            if(pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
                si++;
                pi++;
            } else if(pi < p.length() && p.charAt(pi) == '*') {
                star = pi;
                match = si;
                pi++;
            } else if(star != -1) {
                pi = star+1;
                match++;
                si = match;
            } else {
                return false;
            }
        }
        while(pi < p.length() && p.charAt(pi) == '*')
            pi++;
        return p.length() == pi;
    }
}
