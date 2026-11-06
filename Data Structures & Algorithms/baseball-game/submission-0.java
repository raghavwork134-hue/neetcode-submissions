class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> ops = new Stack<>();

        for(char ch = 0;ch<operations.length;ch++){
            if(operations[ch].equals("+")){
                int top = ops.pop();
                int second = ops.peek();

                ops.push(top);
                ops.push(top + second);

            }

            else if(operations[ch].equals("D")){
                ops.push(2 * ops.peek());
            }
            else if(operations[ch].equals("C")){
                ops.pop();
            }
            else{
                ops.push(Integer.parseInt(operations[ch]));
            }
        }

        int ans = 0;
        for(int i = 0;i<ops.size();i++){
            ans += ops.get(i);
        }
        return ans;
    }
}