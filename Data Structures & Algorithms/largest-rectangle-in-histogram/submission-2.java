class Solution {
    public int largestRectangleArea(int[] heights) {
        // Stack<Integer> stack = new Stack<>();
        // int maxArea = 0;
        // int n = heights.length;

        // for (int i = 0; i <= n; i++) {

        //     int currentHeight = (i == n) ? 0 : heights[i];

        //     while (!stack.isEmpty() &&
        //            currentHeight < heights[stack.peek()]) {

        //         int height = heights[stack.pop()];

        //         int width;

        //         if (stack.isEmpty()) {
        //             width = i;
        //         } else {
        //             width = i - stack.peek() - 1;
        //         }

        //         maxArea = Math.max(maxArea, height * width);
        //     }

        //     stack.push(i);
        // }

        // return maxArea;

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i<= heights.length;i++){

            int currHeight = (i == heights.length)? 0 : heights[i];

            while(!st.isEmpty() && currHeight < heights[st.peek()]){

                int height = heights[st.pop()];
                int width;

                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i - st.peek() - 1;
                }

                maxArea = Math.max(maxArea,height * width);
            }

            st.push(i);
        }
        return maxArea;
    }
}
