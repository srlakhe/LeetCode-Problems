class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int [k];
        if(len1 + len2 < k)
            return result;
        else if(len1 + len2 == k) {
            result = mergeTwoArrays(nums1, nums2, k);
        } else {
            for(int i = 0; i <= k; i++) {
                if(i <= len1 && k - i <= len2) {
                    int[] one = solve(nums1, i);
                    int[] two = solve(nums2, k-i);
                    int[] maxnums = mergeTwoArrays(one, two, k);
                    if(compareArrays(maxnums, 0, result, 0))
                        result = maxnums;
                }
            }
        }
        return result;
    }
   
    private boolean compareArrays(int[] nums1, int start1, int[] nums2, int start2) {
        for(; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if(nums1[start1]>nums2[start2])
                return true;
            if(nums2[start2] > nums1[start1])
                return false;
        }
        return start1 != nums1.length;
    }
    
    private int[] mergeTwoArrays(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        int[] result = new int[k];
        for(int t = 0; t < k; t++) {
            if(compareArrays(nums1, i, nums2, j)) {
                result[t] = nums1[i++];
            } else {
                result[t] = nums2[j++];
            }
        }
        return result;
    }
    private int[] solve(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            
            while(len > 0 && len + nums.length-i>k && nums[i] > res[len-1])
                len--;
            
            if(len < k)
                res[len++] = nums[i];
        }
        return res;
    }
}
