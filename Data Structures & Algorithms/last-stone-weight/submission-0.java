class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new 
        PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){

            int larg = maxHeap.poll();
            int seclarg = maxHeap.poll();

            if(larg != seclarg){
                maxHeap.offer(larg - seclarg);
            }
        }

        if(maxHeap.isEmpty()){
            return 0;
        }

        return maxHeap.peek();
    }
}
