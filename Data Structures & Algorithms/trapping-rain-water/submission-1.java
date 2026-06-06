class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        int i = 0, j = n - 1;
        int lMax = height[0], rMax = height[n - 1];

        while(i < j) {
            if(lMax < rMax) {
                i++;
                lMax = Math.max(lMax, height[i]);

                int val = lMax - height[i];
                res += val > 0 ? val : 0;
            } else {
                j--;

                rMax = Math.max(rMax, height[j]);

                int val = rMax - height[j];
                res += val > 0 ? val : 0;
            }
        }

        return res;
    }
}
