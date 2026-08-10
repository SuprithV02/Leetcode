class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        
        // for(int i = 0; i<nums.length; i++){
        //     for(int j = i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target) {
        //             ans[0] = i;
        //             ans[1] = j;
        //         }
        //     }
        // }

        // return ans;

        Map<Integer, Integer> m = new HashMap<>();

        m.put(nums[0], 0);

        for(int i = 1; i<nums.length;  i++){
            if(m.containsKey(target - nums[i])){
                ans[0] = m.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }

            m.put(nums[i], i);
        }

        return ans;
    }
}