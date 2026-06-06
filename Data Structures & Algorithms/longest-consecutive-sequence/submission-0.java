class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        for(int num : nums) {
            if(!map.containsKey(num)) {
                continue;
            }

            map.remove(num);
            int le = num - 1;
            int re = num + 1;

            while(map.containsKey(le)) {
                map.remove(le);
                le--;
            }

            while(map.containsKey(re)) {
                map.remove(re);
                re++;
            }

            int len = re - le - 1;
            if(len > maxLen){
                maxLen = len;
            } 
        }
        return maxLen;
    }
}
