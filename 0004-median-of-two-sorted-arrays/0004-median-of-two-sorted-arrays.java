class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        

        //merge two arrays into one single sorted array.
    //     int[] newArray = new int[nums1.length + nums2.length];

    //     int i = 0, j = 0, index = 0;
    //     while(i<nums1.length && j<nums2.length){
    //         if(nums1[i]<nums2[j]){
    //             newArray[index] = nums1[i];
    //             i++;
    //         } else {
    //             newArray[index] = nums2[j];
    //             j++;
    //         }
    //         index++;
    //     }

    //     while(i<nums1.length){
    //         newArray[index] = nums1[i];
    //         i++;
    //         index++;
    //     }

    //     while(j<nums2.length){
    //         newArray[index] = nums2[j];
    //         j++;
    //         index++;
    //     }

    //     int length = newArray.length;
    //     int mid = length / 2;

    //     if(length%2 != 0){
    //         return newArray[mid];
    //     } else {
    //         int a = mid-1;
    //         int b = mid;
    //         double ans = (newArray[a] + newArray[b]) / 2.0;
    //         return ans;
    //     }

    // }


    //optimized approach
    //just getting the l1, l2, r1, r2...makes up the whole thing to solve this problem
    if(nums2.length < nums1.length){
        return findMedianSortedArrays(nums2, nums1);
    }

    int n = nums1.length;
    int m = nums2.length;
    int low = 0;
    int high = n;

    while(low <= high){
        int mid1 = low + (high - low) / 2;
        int mid2 = (n+m+1)/2 - mid1;

        int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 -1];
        int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 -1];
        int r1 = (mid1 == n) ? Integer.MAX_VALUE : nums1[mid1];
        int r2 = (mid2 == m) ? Integer.MAX_VALUE : nums2[mid2];

        //pattern
        if(l1 <= r2 && l2 <= r1){
            //odd total 
            if((n+m) % 2 == 1){
                return Math.max(l1, l2);
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

        }
            //too many from nums1
            if(l1 > r2){
                high = mid1 - 1;
            } else {
                //too many from nums2
                low = mid1 + 1;
            }
    }
    return 0;
}
}