class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
       // 1. Count frequencies of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Create buckets where index represents the frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // 3. Collect the top k frequent elements from right to left
        int[] res = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {
            // FIX: Skip empty buckets to avoid NullPointerException
            if (bucket[i] != null) { 
                for (int n : bucket[i]) {
                    res[index++] = n;
                    if (index == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    

    }
}
