class Solution {
    public int splitArray(int[] nums, int k) {
        
        int left = 0;
        int right = 0;

        for(int i = 0;i<nums.length;i++){
            left = Math.max(left,nums[i]);
            right += nums[i];
        }

        int answer = right;

        while(left <= right){
            int mid = left + (right - left)/2;

            int subarrayCount = 1;
            int currentSubarraySum = 0;
            boolean isValidLimit = true;

            for(int i = 0;i<nums.length;i++){
                if(currentSubarraySum + nums[i] > mid ){
                    subarrayCount++;
                    currentSubarraySum = nums[i];
                }
                else{
                    currentSubarraySum += nums[i];
                }
            }   

            if(subarrayCount > k){
                isValidLimit = false;
            }

            if(isValidLimit){
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return answer;
    }
}