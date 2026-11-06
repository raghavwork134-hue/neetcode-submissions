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
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) > nums.length/3){
                res.add(key);
            }
        }

        return res;
    
    
    
    }
}