class Solution {
    public void rotate(int[] nums, int k) {
           reverse(nums, 0, nums.length);
           reverse(nums, 0, k % nums.length);
           reverse(nums, k % nums.length, nums.length);
    }
    
    void reverse(int[] nums, int start, int end) {
        for(int i = start, j = end-1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
