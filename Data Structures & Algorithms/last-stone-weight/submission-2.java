class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // PriorityQueue<Integer> maxHeap = new 
        // PriorityQueue<>(Collections.reverseOrder());

        // for(int stone : stones){
        //     maxHeap.offer(stone);
        // }

        // while(maxHeap.size() > 1){

        //     int larg = maxHeap.poll();
        //     int seclarg = maxHeap.poll();

        //     if(larg != seclarg){
        //         maxHeap.offer(larg - seclarg);
        //     }
        // }

        // if(maxHeap.isEmpty()){
        //     return 0;
        // }

        // return maxHeap.peek();

        List<Integer> res = new ArrayList<>();
        for(int stone : stones){
            res.add(stone);
        }
        while(res.size() > 1){
            Collections.sort(res);
            int larg = res.remove(res.size() - 1);
            int sec = res.remove(res.size() - 1);

            if(larg != sec){
                res.add(larg - sec);
            }
        }
        if(res.size() == 0){
            return 0;
        }
        return res.get(0);
    }

}
