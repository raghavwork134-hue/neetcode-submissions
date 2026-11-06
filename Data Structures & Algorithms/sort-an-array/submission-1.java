class Solution {
    public int[] sortArray(int[] nums) {
        
        // for(int i = 0;i<nums.length;i++){
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[i] > nums[j]){
        //             int temp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = temp;
        //         }
        //     }
        // }
        // return nums;

        int n = nums.length;

        // Phase 1: Build Max-Heap (Rearrange array)
        // Start from the last non-leaf node and move up to the root
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Phase 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum element) to the end of the array
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call max heapify on the reduced heap
            heapify(nums, i, 0);
        }

        return nums;
    }

    // Helper method to maintain the Max-Heap property
    private void heapify(int[] nums, int heapSize, int rootIndex) {
        int largest = rootIndex;       // Initialize largest as root
        int leftChild = 2 * rootIndex + 1;  // Left child index
        int rightChild = 2 * rootIndex + 2; // Right child index

        // If left child is larger than root
        if (leftChild < heapSize && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        // If right child is larger than the largest so far
        if (rightChild < heapSize && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        // If largest is not root, swap and continue heapifying down
        if (largest != rootIndex) {
            int swap = nums[rootIndex];
            nums[rootIndex] = nums[largest];
            nums[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(nums, heapSize, largest);
        }
    }


    
}