class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        gp(result, "", n, 0, 0);
        return result;
    }
    
    void gp(ArrayList<String> result, String temp, int n, int lc, int rc) {
        
        if(rc == n && lc == n) {
            result.add(temp);
            temp = temp.substring(temp.length()-1);
            return;
        }
        
        if(lc < n)
            gp(result, temp+"(", n, lc+1, rc);
        if(rc < lc)
            gp(result, temp+")", n, lc, rc+1);
    }
}
