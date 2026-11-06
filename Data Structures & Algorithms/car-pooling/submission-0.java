class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Arrays.sort(trips,(a,b) -> Integer.compare(a[1],b[1]));

        PriorityQueue<int[]> minHeap = new 
        PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        int currentPassenger = 0;

        for(int[] trip : trips){

            int passengers = trip[0];
            int pickup = trip[1];
            int drop = trip[2];
        

        while(!minHeap.isEmpty() && minHeap.peek()[0] <= pickup){
            currentPassenger -= minHeap.poll()[1];
        }

        currentPassenger += passengers;

        if(currentPassenger > capacity){
            return false;
        }
    
        minHeap.offer(new int[]{drop, passengers});
        }
        return true;

    }
}