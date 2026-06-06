class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        
        HashSet<Character> set = new HashSet<>();
        int si = 0, ei = 0;
        
        while(ei < s.length() && si < s.length()) {
            char ch = s.charAt(ei);

            if(set.contains(ch)) {
                while(set.contains(ch) && si < s.length()) {
                    set.remove(s.charAt(si));
                    si++;
                }
            }

            set.add(ch);
            ei++;
        
            // System.out.println(si + " " + ei);
            maxLen = Math.max(maxLen, ei - si);
        }

        return maxLen;
    }
}
