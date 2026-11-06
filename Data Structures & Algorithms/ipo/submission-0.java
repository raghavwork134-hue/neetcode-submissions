class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        

        PriorityQueue<int[]> minHeap = new 
        PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> maxHeap = new 
        PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i<profits.length;i++){
            minHeap.offer(new int[]{capital[i],profits[i]});
        }

        for(int i = 0;i<k;i++){

            while(!minHeap.isEmpty() && minHeap.peek()[0] <= w){
                maxHeap.offer(minHeap.poll()[1]);
            }

            if(maxHeap.isEmpty()){
                break;
            }

            w += maxHeap.poll();
        }
        return w;
    }
}