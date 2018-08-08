public class Solution {
  public boolean canWin(String s) {
      if(s.length() == 0)
        return false;
      return canPlayerWin(s.toCharArray());
  }
  
  boolean canPlayerWin(char[] arr) {
      for(int i = 0; i < arr.length-1; i++) {
          if(arr[i] == arr[i+1] && arr[i] = '+') {
              arr[i] = '-';
              arr[i+1] = '-';
              if(!canPlayerWin(arr))
                return true;
              arr[i] = '+';
              arr[i+1] = '+';
          }
      }
      return false;
  }
}
