class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int left = 0;
        int right = 0;

        for(int i = 0;i<weights.length;i++){
            left = Math.max(weights[i],left);
            right += weights[i];
        }

        int answer = right;

        while(left <= right){
            int mid = left + (right - left)/2;

            int requiredDay = 1;
            int currentLoad = 0;

            for(int i = 0;i<weights.length;i++){
                
                if(currentLoad + weights[i] > mid){
                    requiredDay++;
                    currentLoad = 0;
                }

                currentLoad += weights[i];
            }

            if(requiredDay <= days){
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