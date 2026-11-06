class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // try brute force also

        // int len1 = nums1.length, len2 = nums2.length;
        // int[] merged = new int[len1 + len2];
        // System.arraycopy(nums1, 0, merged, 0, len1);
        // System.arraycopy(nums2, 0, merged, len1, len2);
        // Arrays.sort(merged);

        // int totalLen = merged.length;
        // if (totalLen % 2 == 0) {
        //     return (merged[totalLen / 2 - 1] + merged[totalLen / 2]) / 2.0;
        // } else {
        //     return merged[totalLen / 2];

        

                // optimised
        // Always binary search on smaller array
        // if (nums1.length > nums2.length) {
        //     return findMedianSortedArrays(nums2, nums1);
        // }

        // int m = nums1.length;
        // int n = nums2.length;

        // int left = 0;
        // int right = m;

        // while (left <= right) {

        //     int partitionX = left + (right - left) / 2;
        //     int partitionY = (m + n + 1) / 2 - partitionX;

        //     int maxLeftX = (partitionX == 0)
        //             ? Integer.MIN_VALUE
        //             : nums1[partitionX - 1];

        //     int minRightX = (partitionX == m)
        //             ? Integer.MAX_VALUE
        //             : nums1[partitionX];

        //     int maxLeftY = (partitionY == 0)
        //             ? Integer.MIN_VALUE
        //             : nums2[partitionY - 1];

        //     int minRightY = (partitionY == n)
        //             ? Integer.MAX_VALUE
        //             : nums2[partitionY];

        //     if (maxLeftX <= minRightY &&
        //         maxLeftY <= minRightX) {

        //         if ((m + n) % 2 == 0) {

        //             return (Math.max(maxLeftX, maxLeftY)
        //                   + Math.min(minRightX, minRightY))
        //                   / 2.0;
        //         }

        //         else {

        //             return Math.max(maxLeftX, maxLeftY);
        //         }
        //     }

        //     else if (maxLeftX > minRightY) {

        //         right = partitionX - 1;
        //     }

        //     else {

        //         left = partitionX + 1;
        //     }
        // }

        // return 0.0;

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;

        while(left <= right){
            int partitionX = left + (right-left)/2;
            int partitionY = (m+n+1)/2 - partitionX;

            int maxleftX = (partitionX == 0) ? Integer.MIN_VALUE :
                            nums1[partitionX-1];
            
            int minrightX = (partitionX == m) ? Integer.MAX_VALUE : 
                            nums1[partitionX];

            int maxleftY = (partitionY == 0) ? Integer.MIN_VALUE : 
                            nums2[partitionY-1];

            int minrightY = (partitionY == n) ? Integer.MAX_VALUE : 
                            nums2[partitionY];

            if(maxleftX <= minrightY && maxleftY <= minrightX){
                if((m+n) % 2 == 0){
                    return (Math.max(maxleftX,maxleftY) + 
                        Math.min(minrightX,minrightY))/2.0;
                }
                else{
                    return Math.max(maxleftX,maxleftY);
                }
            }
            else if(maxleftX > minrightY){
                right = partitionX - 1;
            }
            else{
                left = partitionX + 1;
            }
        }
        return 0.0;

    }
}
