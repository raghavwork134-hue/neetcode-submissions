class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();
        int maxarea = 0;
        for(int i = 0;i <= heights.length;i++){

            int currheight = (i == heights.length)? 0:heights[i];

            while(!st.isEmpty() && currheight < heights[st.peek()]){
                int height = heights[st.pop()];
                int width;

                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i - st.peek() - 1;
                }

                int area = height * width;
                maxarea = Math.max(maxarea,area);
            }
            st.push(i);
        }
        return maxarea;
    }
}
