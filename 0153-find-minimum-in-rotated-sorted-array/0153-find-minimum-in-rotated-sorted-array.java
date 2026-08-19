class Solution {
    public int findMin(int[] nums) {
        
        int length = nums.length;

        int l = 0;
        int r = length - 1;

        int res = nums[0];

        while(l<=r){
            if(nums[l] < nums[r]){
                res = Math.min(res, nums[l]);
                break;
            }

            int m = (l+r)/2;
            res = Math.min(res, nums[m]);
            if(nums[m] >= nums[l]){
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return res;


    }
}