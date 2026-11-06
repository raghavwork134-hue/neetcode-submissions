class Solution {
    public String reorganizeString(String s) {
        
        int freq[] = new int[26];

        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new 
        PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int i = 0;i<freq.length;i++){
            if(freq[i] > 0){
                maxHeap.offer(new int[]{i,freq[i]});
            }
        }

        StringBuilder ans = new StringBuilder();

        int prev[] = null;

        while(!maxHeap.isEmpty()){

            int[] current = maxHeap.poll();

            ans.append((char)(current[0] + 'a'));

            current[1]--;

            if(prev != null && prev[1] > 0){
                maxHeap.offer(prev);
            }

            prev = current;
        }

        if(ans.length() != s.length()){
            return "";
        }

        return ans.toString();
    }
}