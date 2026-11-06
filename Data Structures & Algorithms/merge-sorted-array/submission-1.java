class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
                // 1
        // for(int i = 0;i<n;i++){
        //     nums1[i+m] = nums2[i];
        // }
        // Arrays.sort(nums1);
    
                // 2
        
        int i = m - 1;
        int j = n - 1;
        int idx = m + n - 1;

        while( i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[idx] = nums1[i];
                i--;
            }
            else{
                nums1[idx] = nums2[j];
                j--;
            }
            idx--;
        }

        while(j >= 0){
            nums1[idx] = nums2[j];
            j--;
            idx--;
        }
    
    
    }
}