class Solution {
    public int[] twoSum(int[] numbers, int target) {
        

        int ans[] = new int[2];

        int start = 0, end = numbers.length - 1;

        while(start < end){
            int sum = numbers[start] + numbers[end];

            if(sum > target){
                end--;
            } else if(sum < target){
                start++;
            } else {
                ans[0] = start + 1;
                ans[1] = end + 1;
                return ans;
            }
        }

        return ans;
    }
}