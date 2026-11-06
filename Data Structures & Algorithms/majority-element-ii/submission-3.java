class Solution {
    public List<Integer> majorityElement(int[] nums) {

                    // 1        
        // HashSet<Integer> res = new HashSet<>();

        // for(int i = 0;i<nums.length;i++){
        //     int count = 0;
        //     for(int j = 0;j<nums.length;j++){
        //         if(nums[i] == nums[j]){
        //             count++;
        //         }
        //     }
        //     if(count > nums.length/3){
        //        res.add(nums[i]);
        //     }
            
        // }
        // return new ArrayList<>(res);


                                // 2
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i = 0;i<nums.length;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        // }

        // List<Integer> res = new ArrayList<>();
        // for(int key : map.keySet()){
        //     if(map.get(key) > nums.length/3){
        //         res.add(key);
        //     }
        // }

        // return res;
    
                        // 3
        int candidate1 = 0;
        int candidate2 = 0;

        int count1 = 0;
        int count2 = 0;

        // Phase 1: Find candidates
        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }

            else if (num == candidate2) {
                count2++;
            }

            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }

            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }

            else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }

            else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        int limit = nums.length / 3;

        if (count1 > limit) {
            result.add(candidate1);
        }

        if (count2 > limit) {
            result.add(candidate2);
        }

        return result;
    
    }
}