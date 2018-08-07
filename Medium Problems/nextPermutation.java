class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for(i = nums.length-1; i >= 1; i--) {
            if(nums[i]>nums[i-1])
                break;
        }
        if(i == 0) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int j = nums.length-1;
        while(nums[j] <= nums[i-1])
            j--;
        int temp = nums[j];
        nums[j] = nums[i-1];
        nums[i-1] = temp;
        if(i != nums.length-1)
        reverse(nums, i, nums.length-1);
    }
    void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j--;
            i++;
        }
    }
}
