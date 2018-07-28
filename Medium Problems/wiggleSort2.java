class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int m = (n + 1) / 2;
        int[] copy = Arrays.copyOf(nums, n);
        int median = kthSmallestNumber(nums, m);
        for(int i = 0, j = 0, k = n - 1; j <= k;)
            if(copy[j] < median)
                swap(copy, i++, j++);
            else if(copy[j] > median)
                swap(copy, k--, j);
            else
                j++;
        for(int i = 0, j = m-1; j >= 0; i+=2, j--)
            nums[i] = copy[j];
        for(int i = 1, j = n-1; j >= m; i+=2, j--)
            nums[i] = copy[j];
    }
    
    private int kthSmallestNumber(int[] nums, int k) {
        Random random = new Random();
        for(int i = nums.length-1; i >= 0; i--)
            swap(nums, i, random.nextInt(i+1));
        int left = 0, right = nums.length - 1;
        k--;
        while(left < right) {
            int m = getIndex(nums, left, right);
            if(m < k) {
                left = m + 1;
            } else if(m > k) {
                right = m - 1;
            } else
                break;
        }
        return nums[k];
    }
    
    private int getIndex(int nums[], int l, int r) {
        int i = l;
        for(int j = l+1; j<=r; j++)
            if(nums[l] > nums[j])
                swap(nums, ++i, j);
        swap(nums, i, l);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
