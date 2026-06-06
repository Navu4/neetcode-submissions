class Solution {
    public int maxProfit(int[] prices) {
        int minVal = (int)1e9;
        int maxP = 0;

        for(int i = 0; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            maxP = Math.max(maxP, prices[i] - minVal);
        }

        return maxP;
    }
}
