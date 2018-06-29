class Solution {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length-1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && (zeroIndex <= i)) {
                int temp = nums[zeroIndex];
                nums[zeroIndex] = 0;
                nums[i] = temp;
                zeroIndex++;
                i--;
            }
            else if(nums[i] == 2 && (twoIndex >= i)) {
                int temp = nums[twoIndex];
                nums[twoIndex] = 2;
                nums[i] = temp;
                twoIndex--;
                i--;
            }
        }
    }
}
