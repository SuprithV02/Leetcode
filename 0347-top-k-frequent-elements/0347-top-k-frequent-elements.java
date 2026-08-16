class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //This is called the bucket sort
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer>[] li = new List[nums.length + 1];

        for(int i = 0; i<li.length; i++){
            li[i] = new ArrayList<>();
        }

        for(int i = 0; i<nums.length; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            li[e.getValue()].add(e.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = li.length - 1; i>0 && index<k ; i--){
            for(int n : li[i]){
                res[index++] = n;
                if(index == k){
                    return res;
                } 
            }
        }

        return res;
    }
}