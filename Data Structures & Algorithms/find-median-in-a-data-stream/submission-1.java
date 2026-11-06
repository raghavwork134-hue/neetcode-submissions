class MedianFinder {

    // PriorityQueue<Integer> maxHeap;
    // PriorityQueue<Integer> minHeap;

    // public MedianFinder() {
        
    //     maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    //     minHeap = new PriorityQueue<>();
    // }
    
    // public void addNum(int num) {
        
    //     maxHeap.offer(num);

    //     minHeap.offer(maxHeap.poll());

    //     if(minHeap.size() > maxHeap.size()){
    //         maxHeap.offer(minHeap.poll());
    //     }
    // }
    
    // public double findMedian() {
        
    //     if(maxHeap.size() > minHeap.size()){
    //         return maxHeap.peek();
    //     }

    //     return (maxHeap.peek() + minHeap.peek()) / 2.0;
    // }


                        // brute force
    private ArrayList<Integer> data;

    public MedianFinder() {
        data = new ArrayList<>();
    }

    public void addNum(int num) {
        data.add(num);
    }

    public double findMedian() {
        Collections.sort(data);
        int n = data.size();
        if ((n % 2) == 1) {
            return data.get(n / 2);
        } else {
            return (data.get(n / 2) + data.get(n / 2 - 1)) / 2.0;
        }
    }
}
