class Solution {
    public int maxArea(int[] heights) {

        //  int left = 0;
        // int right = heights.length - 1;

        // int maxWater = 0;

        // while (left < right) {

        //     int h = Math.min(heights[left], heights[right]);

        //     int width = right - left;

        //     int area = h * width;

        //     maxWater = Math.max(maxWater, area);

        //     // Move smaller height pointer
        //     if (heights[left] < heights[right]) {
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }

        // return maxWater;

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while(left < right){
            int height = Math.min(heights[left],heights[right]);

            int width = right - left;

            maxArea = Math.max(maxArea,height * width);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;

    }
}
