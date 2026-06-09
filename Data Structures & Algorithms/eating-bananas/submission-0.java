class Solution {
    public int timeRequiredToEat(int[] arr, int n, int k) {
        int time = 0;
        for(int i = 0; i < n; i++) {
            time += Math.ceil((double)arr[i] / (double)k);
        }
        return time;
    }
    public int maxBananas(int[] arr, int n) {
        int max = -1;
        for(int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, n = piles.length;
        int high = maxBananas(piles, n);

        while(low <= high) {
            int mid = (low + high) / 2;
            int time = timeRequiredToEat(piles, n, mid);
            if(time <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
