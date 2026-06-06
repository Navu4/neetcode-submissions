class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];

        int res = 0;
        int lMax = 0;
        for(int i = 0; i < n; i++) {
            lMax = Math.max(lMax, height[i]);
            leftToRight[i] = lMax;
        } 

        int rMax = 0;
        for(int i = n - 1; i >= 0; i--) {
            rMax = Math.max(rMax, height[i]);
            rightToLeft[i] = rMax;
        }

        for(int i = 0; i < n; i++) {
            int val = Math.min(leftToRight[i], rightToLeft[i]) - height[i];
            res += val > 0 ? val : 0;
        }

        return res;
    }
}
