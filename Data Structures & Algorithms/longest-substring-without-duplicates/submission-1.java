class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;

        Set<Character> set = new HashSet<>();

        int len = 0;
        while(i < n && j < n) {
            char ch = s.charAt(j);
            boolean has = set.contains(ch);

            if(has) {
                do {
                    set.remove(s.charAt(i));
                    i++;
                } while(i < n && set.contains(ch));
            } else {
                set.add(ch);
                j++;
            }

            len = Math.max(len, j - i);
        }
        return len;
    }
}
