class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int freq[] = new int[26];

        PriorityQueue<Integer> maxheap = new 
        PriorityQueue<>(Collections.reverseOrder());

        Queue<int[]> q = new LinkedList<>();

        for(char task : tasks){
            freq[task - 'A']++;
        }

        for(int i = 0;i<26;i++){
            if(freq[i] > 0){
                maxheap.offer(freq[i]);
            }
        }

        int time = 0;
        while(!maxheap.isEmpty() || !q.isEmpty()){
            time++;
            if(!maxheap.isEmpty()){
                int count = maxheap.poll();
                count--;
                if(count > 0){
                    q.offer(new int[]{count,time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxheap.offer(q.poll()[0]);
            }
        }

        return time;


    }
}
