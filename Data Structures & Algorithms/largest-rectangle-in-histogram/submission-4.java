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

        int n = heights.length;
        int maxarea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<=n;i++){
            int currheight = (i == n)? 0 : heights[i];

            while(!st.isEmpty() && currheight < heights[st.peek()]){
                int height = heights[st.pop()];
                int width;

                if(st.isEmpty()){
                    width = i;
                }else{
                    width = i-st.peek()-1;
                }
                maxarea = Math.max(maxarea,height*width);
            }
            st.push(i);
        }
        return maxarea;

    }
}
