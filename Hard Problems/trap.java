class Solution {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int leftmax = height[0];
        int rightmax = height[height.length-1];
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left <= right) {
            if(height[left] < height[right]) {
                if(height[left] > leftmax)
                    leftmax = height[left];
                else
                    res += (leftmax - height[left]);
                left++;
            } else {
                if(height[right] > rightmax)
                    rightmax = height[right];
                else
                    res += (rightmax - height[right]);
                right--;
            }
        }
        
        return res;
    }
