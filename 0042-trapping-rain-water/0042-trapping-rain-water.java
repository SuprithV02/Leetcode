class Solution {
    public int trap(int[] height) {
         
         if(height == null || height.length == 0){
            return 0;
         }

         int l = 0, r = height.length - 1;
         int leftMax = height[l], rightMax = height[r];
         int res = 0;

        //The basic concept over here is (left maximumn - present index left)
        //similary the (right maximum - present index right)
        //we add both the res till left < right
         while(l < r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
         }

         return res;
    }
}