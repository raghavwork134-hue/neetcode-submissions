class Solution {
    public int longestConsecutive(int[] nums) {
        
        // HashSet<Integer> set = new HashSet<>();

        // for(int i = 0;i<nums.length;i++){
        //     set.add(nums[i]);
        // }
        // int longest = 0;
        // for(int i = 0;i<nums.length;i++){
        //     int currNum = nums[i];

        //     if(!set.contains(currNum - 1)){
        //         int currNumInStreak = currNum;
        //         int currStreak = 1;

        //         while(set.contains(currNumInStreak + 1)){
        //             currNumInStreak++;
        //             currStreak++;
        //         }
        //         longest = Math.max(longest,currStreak);
        //     }
        // }
        // return longest;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;
        for(int num : nums){
            int currNum = num;

            if(!set.contains(currNum - 1)){
                int currNumInStreak = currNum;
                int currStreak = 1;

                while(set.contains(currNumInStreak + 1)){
                    currNumInStreak++;
                    currStreak++;
                }

                longest = Math.max(longest,currStreak);
            }
        }
        return longest;
    }
}
