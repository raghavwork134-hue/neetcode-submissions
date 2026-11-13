class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxheap = new 
        PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i<stones.length;i++){
            maxheap.offer(stones[i]);
        }

        while(maxheap.size() > 1){
            int x = maxheap.poll();
            int y = maxheap.poll();

            if(x != y){
                maxheap.offer(x-y);
            }
        }

        if(maxheap.size() == 0){
            return 0;
        } 
        return maxheap.peek();
    }
}
