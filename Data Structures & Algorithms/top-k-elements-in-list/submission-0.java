class Solution {
    class Pair {
        int val;
        int count;
        Pair(){}
        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return b.count - a.count;
        });

        for(int key: map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }

        int[] ans = new int[k];
        while(k-- > 0 && pq.size() > 0) {
            Pair p = pq.remove();
            ans[k] = p.val; 
        }

        return ans;
    }
}
