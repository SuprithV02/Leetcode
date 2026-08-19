class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int length = piles.length;
        int max = 0;
        for(int pile : piles){
            max = Math.max(pile, max);
        }

        int left = 1, right = max;

        while(left<=right){

            int mid = (left + right) / 2;
            long hours = 0;
            for(int pile : piles){
                 hours += (pile + mid - 1)/mid;
            }

            if(hours <= h){
                right = mid - 1; 
            } else  {
                left = mid + 1;
            }
        }

        return left;
    }
}