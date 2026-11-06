class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = 0;

        for(int i = 0;i<matchsticks.length;i++){
            sum += matchsticks[i];
        }

        if(sum % 4 != 0){
            return false;
        }

        int target = sum/4;

        Arrays.sort(matchsticks);

        int left = 0;
        int right = matchsticks.length - 1;
        while(left < right){
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }

        int sides[] = new int[4];

        return backtrack(matchsticks,0,sides,target);
    }

    private boolean backtrack(int[] matchsticks, int index, 
    int[] sides, int target){

        if(index == matchsticks.length){
            return sides[0] == target && 
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = matchsticks[index];

        for(int i = 0;i<4;i++){

            // Cannot exceed target length
            if (sides[i] + stick > target) {
                continue;
            }

            // Choose
            sides[i] += stick;

            // Explore
            if (backtrack(matchsticks, index + 1, sides, target)) {
                return true;
            }

            // Backtrack
            sides[i] -= stick;
        }

        return false;
        
    }
}