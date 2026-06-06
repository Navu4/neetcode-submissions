class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int r = 0;

        Deque<Integer> que = new LinkedList<>();

        for(int i = 0; i < n; i++) {

            // check out of bound
            if(!que.isEmpty() && que.peek() <= i - k) {
                que.poll();
            }

            // maintain decreasing order
            while(!que.isEmpty() && nums[que.peekLast()] < nums[i]) {
                que.pollLast();
            }

            que.offer(i);
            if(i >= k - 1) {
                res[r] = nums[que.peek()];
                r++;
            }
        }

        return res;
    }
}
