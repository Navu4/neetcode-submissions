class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>(); 
        
        for(String str: strs) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

            if(map.containsKey(freq)){
                List<String> ll = map.get(freq);
                ll.add(str);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(freq, arr);
            }        
        }

        for(List<String> ll : map.values()){
            result.add(ll);
        }

        return result;
    }
}
