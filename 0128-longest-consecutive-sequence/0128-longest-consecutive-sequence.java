class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Set<Integer> s = new HashSet<>();

        for(int i = 0; i<nums.length; i++){
            s.add(nums[i]);
        }

        int maxLen = 1;
        for(Integer num : s){
            if(s.contains(num - 1)){
                continue;
            } else {
                int i = 1;
                int len = 1;
                while(s.contains(num + i)){
                    len++;
                    i++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}