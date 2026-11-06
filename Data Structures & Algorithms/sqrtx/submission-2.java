class Solution {
    public int mySqrt(int x) {
        
        int left = 0;
        int right = x;
        int result = 0;

        while(left <= right){
            int mid = left + (right - left)/2;

            long sq = (long)mid * mid;

            if(sq == x){
                return mid;
            }
            else if(sq > x){
                right = mid - 1;
            }
            else{
                result = mid;
                left = mid + 1;
            }
        }

        return result;
        
    }
}