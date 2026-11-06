class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // // Step 1: Frequency map
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // // Step 2: Create buckets
        // List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // for (int key : map.keySet()) {

        //     int freq = map.get(key);

        //     if (bucket[freq] == null) {
        //         bucket[freq] = new ArrayList<>();
        //     }

        //     bucket[freq].add(key);
        // }

        // // Step 3: Collect top k frequent elements
        // int[] result = new int[k];
        // int index = 0;

        // for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

        //     if (bucket[i] != null) {

        //         for (int num : bucket[i]) {

        //             result[index++] = num;

        //             if (index == k) {
        //                 break;
        //             }
        //         }
        //     }
        // }

        // return result;   

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Convert map entries to a list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        
        // Step 3: Sort the list by values in increasing (ascending) order
        list.sort((a, b) -> a.getValue().compareTo(b.getValue()));
        
        // Step 4: Extract the last k elements
        int[] result = new int[k];
        int index = 0;
        int n = list.size();
        for (int i = n - k; i < n; i++) {
            result[index++] = list.get(i).getKey();
        }
        
        return result; 
    
    }
}