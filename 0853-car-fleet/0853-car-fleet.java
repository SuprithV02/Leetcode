class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        // Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());

        // for(int i = 0; i<position.length; i++){
        //     m.put(position[i], (double)speed[i]);
        // }

        int n = position.length;
        int[][] cars = new int[n][2];

        for(int i = 0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> s = new Stack<>();

        for(int[] car : cars){
            double time = (double)(target - car[0]) / car[1];
            if(s.isEmpty() || time > s.peek()){
                s.push(time);
            }
        }

        return s.size();
    }
}
 
// [10, 8, 0, 5 3] -> position
// [2,4,1,1,3] -> speed

// target - position / speed

// time -> [1,1,12,7,3] 

//sort based on position(desc) -> [1,1,7,3,12]

//stack (present > stack's peek) -> 1,7,12