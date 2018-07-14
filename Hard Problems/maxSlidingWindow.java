class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<k ||nums.length==0)
            return new int[0];
        int[] result = new int[nums.length-k+1];
        int j = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            
            while(!deque.isEmpty() && deque.peek() < i-k+1 )
                deque.poll();
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.removeLast();
            deque.offer(i);
            if(i >= k-1) {
                result[j++] = nums[deque.peek()];
            }
        }
        return result;
    }
}
