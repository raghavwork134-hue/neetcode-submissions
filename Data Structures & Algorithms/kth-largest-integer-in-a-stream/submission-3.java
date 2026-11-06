class KthLargest {

    // private PriorityQueue<Integer> minHeap;
    // private int k;

    private PriorityQueue<Integer> minheap;
    private int k;

    public KthLargest(int k, int[] nums) {
        // this.k = k;
        // minHeap = new PriorityQueue<>();

        // for(int num : nums){
        //     minHeap.offer(num);

        //     if(minHeap.size() > k){
        //         minHeap.poll();
        //     }
        // }

        this.k = k;
        minheap = new PriorityQueue<>();
        for(int num : nums){
            minheap.offer(num);
            if(minheap.size() > k){
                minheap.poll();
            }
        }
   }

    

    public int add(int val) {
        
        // minHeap.offer(val);

        // if(minHeap.size() > k){
        //     minHeap.poll();
        // }

        // return minHeap.peek();

        minheap.offer(val);
        if(minheap.size() > k){
            minheap.poll();
        }
        return minheap.peek();
    }
}
