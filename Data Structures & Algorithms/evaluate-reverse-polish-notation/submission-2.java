class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int top = st.pop();
                int second = st.pop();
                st.push(top + second);
            }

            else if(tokens[i].equals("*")){
                int top = st.pop();
                int second = st.pop();
                st.push(top * second);
            }

            else if(tokens[i].equals("-")){
                int top = st.pop();
                int second = st.pop();
                st.push(second - top);
            }

            else if(tokens[i].equals("/")){
                int top = st.pop();
                int second = st.pop();
                st.push(second / top);
            }

            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.pop();

    }
}
