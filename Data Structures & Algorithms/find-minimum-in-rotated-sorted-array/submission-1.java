class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int minVal = (int)1e9;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[mid]) {
                minVal = Math.min(minVal,arr[low]);
                low = mid + 1;
            } else {
                minVal = Math.min(minVal,arr[mid]);
                high = mid - 1;
            }
        }

        return minVal;
    }
}
