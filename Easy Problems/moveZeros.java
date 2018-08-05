class Solution {
    public void moveZeroes(int[] nums) {
        int insertIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                continue;
            nums[insertIndex++] = nums[i];
        }
        for(int i = insertIndex; i < nums.length; i++)
            nums[i] = 0;
    }
}
