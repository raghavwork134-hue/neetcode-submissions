class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // int left = 0;
        // int right = numbers.length - 1;
        // // int result[] = new int[2];
        
        // while(left < right){
        //     if(numbers[left] + numbers[right] == target){
        //         // result[0] = left + 1;
        //         // result[1] = right + 1;
        //         // break; OR 
        //         return new int[]{left + 1, right + 1};
        //     }

        //     else if(numbers[left] + numbers[right] > target){
        //         right--;
        //     }
            
        //     else{
        //         left++;
        //     }
        // }
        // return new int[]{};

        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target){
                return new int[]{left +1,right+1};
            }
            else if(sum > target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[]{};
    }
}
