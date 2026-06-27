class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        HashMap<Integer,Integer> freq = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry: freq.entrySet()) {
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            int[] curr = pq.poll();
            res[i] = curr[0];
        }
        return res;
    }
}
