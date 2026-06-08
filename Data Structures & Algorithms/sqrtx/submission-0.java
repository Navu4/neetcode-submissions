class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        int start = 0, end = x, ans = -1;
        while(start <= end) {
            int mid = start + (end - start ) / 2;
            if(mid <= x / mid) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}