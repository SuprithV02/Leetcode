class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;
        
        Arrays.sort(nums);

        int count = 1, maxCount = 1;

        for(int i = 0; i<nums.length - 1; i++){

            if(nums[i+1] == nums[i]) continue;
            if(nums[i+1] == nums[i] + 1){
                count ++;
            } else {
                count = 1;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}