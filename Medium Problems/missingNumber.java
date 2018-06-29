class Solution {
    public int missingNumber(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length; i++) {
            x = x ^ i;
            x = x ^ nums[i];
        }
        x = x ^ nums.length;
        return x;
    }
}
