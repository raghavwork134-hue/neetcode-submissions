class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // int result[] = new int[2];

        // for(int i = 0;i<nums.length;i++){
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[i] + nums[j] == target){
        //             result[0] = i;
        //             result[1] = j;
        //         }
        //     }
        // }
        // return result;

        // can solve using sorting and two pointer but need to store original array

                // optimised  TC - O(n) SC - O(n)
        // HashMap<Integer,Integer> map = new HashMap<>();

        // for(int i = 0;i<nums.length;i++){
        //     int num = nums[i];
        //     int compl = target - num;

        //     if(map.containsKey(compl)){
        //         return new int[]{map.get(compl),i};
        //     }

        //     map.put(num,i);
        // }
        // return new int[]{};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){

            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};

    

    }
}
