class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        // for(int i = 0;i<nums.length;i++){
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[i] == nums[j] && Math.abs(i-j) <= k){
        //             return true;
        //         }
        //     }
        // }
        // return false;

                            // 2
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i = 0;i<nums.length;i++){
        //     if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
        //         return true;
        //     }
        //     map.put(nums[i],i);
        // }
        // return false;


                            // 3
         HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;


    }
}