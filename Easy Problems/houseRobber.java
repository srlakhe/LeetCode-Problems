class Solution {
    public int rob(int[] nums) {
        int maxi = 0;
        int maxe = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = Math.max(maxe + nums[i], nums[i]);
            maxe = Math.max(maxe, maxi);
            maxi = temp;
        }
        return Math.max(maxe, maxi);
    }
}
