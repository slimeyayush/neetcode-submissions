class Solution {
    public static class Pair {
        int[] coor;
        int dist;

        Pair(int[] coor,int dist) {
            this.coor = coor;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            int distA = a.dist;
            int distB = b.dist;
            int[] co = a.coor;
            int[] cob = b.coor;
            // int distA = co[0]*co[0] + co[1]*co[1];
            // int distB = cob[0]*cob[0] + cob[1]*cob[1];
            if(distA == distB) {
                int diff = co[0] - cob[0];
                if(diff == 0) {
                    return co[1] - cob[1];
                }
                return diff;
            }
            return distB - distA;
        });

        for(int[] pair:points) {
            int dist = pair[0]*pair[0] + pair[1]*pair[1];
            Pair newPair = new Pair(pair,dist);
            pq.offer(newPair);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int idx = 0;
        int size = pq.size();
        int[][] res = new int[size][2];
        while(!pq.isEmpty()) {
            res[idx++] = pq.poll().coor;
        }

        return res;

    }
}
