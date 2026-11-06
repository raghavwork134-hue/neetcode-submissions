class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
                            // brute 
         int n = temperatures.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            int j = i + 1;
            for(j = i + 1;j<n;j++) {
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
                count++;
            }
            count = (j == n) ? 0 : count;
            res[i] = count;
        }
        return res;
        
                        // optimised
        // int n = temperatures.length;
        // int[] answer = new int[n];

        // Stack<Integer> stack = new Stack<>();

        // for (int i = 0; i < n; i++) {

        //     while (!stack.isEmpty() &&
        //            temperatures[i] > temperatures[stack.peek()]) {

        //         int index = stack.pop();

        //         answer[index] = i - index;
        //     }

        //     stack.push(i);
        // }

        // return answer;
    }
}
