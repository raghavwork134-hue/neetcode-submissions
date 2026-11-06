class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // try brute force also

        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int row = 0;row <rows;row++){
            for(int col = 0;col <cols;col++){
                if(matrix[row][col] == target){
                    return true;
                }
            }
        }
        return false;

        //                 // optimised
        // int rows = matrix.length;
        // int cols = matrix[0].length;

        // int left = 0;
        // int right = rows * cols - 1;

        // while(left <= right){

        //     int mid = left + (right - left)/2;

        //     int row = mid / cols;
        //     int col = mid % cols;
            
        //     if(matrix[row][col] == target){
        //         return true;
        //     }
        //     else if(matrix[row][col] > target){
        //         right = mid - 1;
        //     }
        //     else{
        //         left = mid + 1;
        //     }

        // }

        // return false;
    }
}
