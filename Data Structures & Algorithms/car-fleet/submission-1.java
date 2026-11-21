class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] ps = new int[n][2];
        for(int i=0; i<n; i++) {
            ps[i][0] = position[i];
            ps[i][1] = speed[i];
        }
        Arrays.sort(ps,(a,b) -> {
            return Integer.compare(b[0],a[0]);
        });
        int fleet = 0;
        ArrayDeque<Double> stack = new ArrayDeque<>();
        for(int[] car:ps) {
            double time = (double)(target - car[0])/car[1];
            if(stack.isEmpty() || time > stack.peek() ) {
                 fleet++;
                 stack.push(time);
            }
        }
        return stack.size();

    }
}
