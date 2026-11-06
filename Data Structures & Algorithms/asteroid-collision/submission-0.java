class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<asteroids.length;i++){

            boolean destroyed = false;

            while(!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0){

                if(st.peek() < -asteroids[i]){
                    st.pop();
                }
                else if(st.peek() == -asteroids[i]){
                    st.pop();
                    destroyed = true;
                    break;
                }
                else{
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                st.push(asteroids[i]);
            } 
        }

        int[] result = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;

    }
}