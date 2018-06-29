class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length <= 1)
            return -1;
        
        int slow = 0;
        int fast = 0;
        
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }
        
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
