class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    void remove(List<String> res, String s, int start, int lastj, char[] par) {
      for(int stack=0, i = start; i < s.length(); i++) {
          if(s.charAt(i) == par[0])
              stack++;
          if(s.charAt(i) == par[1])
              stack--;
          if(stack >= 0)
              continue;
          for(int j = lastj; j <= i; j++) {
              if(s.charAt(j) == par[1] && (j == lastj || s.charAt(j-1) != par[1]))
                  remove(res, s.substring(0, j)+s.substring(j+1, s.length()), i, j, par);
          }
          return;
      }
      String reversed = new StringBuilder(s).reverse().toString();
      if(par[0] == '(')
          remove(res, reversed, 0, 0, new char[]{')', '('});
      else
          res.add(reversed);
    }
}
