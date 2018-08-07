class Solution {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
      int next = lower;
      List<String> result = new ArrayList<>();
      for(int i = 0; i < nums.length; i++) {
          if(lower == Integer.MAX_VALUE)
              return result;
          if(nums[i] < next)
            continue;
          if(nums[i] > next) {
            result.add(getRange(next, nums[i]-1));
          }
          if(nums[i] == Integer.MAX_VALUE)
              break;
          next = nums[i]+1;
      }
      if(next <= upper)
          result.add(getRange(next, upper));
      return result;
  }
  
  String getRange(int n1, int n2) {
      return n1 == n2 ? String.valueOf(n1) : String.valueOf(n1) + "=>" + String.valueOf(n2); 
  }
}
