class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int[] freq = new int[27];

        int maxLen = 0;
        int maxFreq = 0;

        while(j < n && i < n) {
            // increase freq 
            freq[s.charAt(j) - 'A']++;

            // calculate maximum frequecy in the given window 
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);


            // window size : j - i + 1
            int windowSize = j - i + 1;
            if(windowSize - maxFreq > k) {
                // reduce window as no. of elements can be replaced are k only
                // increase i th index and remove freq of ith value from freq map
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            // new window after above computation 
            int newWindow = j - i + 1;
            maxLen = Math.max(maxLen, newWindow); // calculate max valid window

            j++;
        } 

        return maxLen;
    }
}
