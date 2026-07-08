class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
    int da = Math.abs(a-x);
    int db = Math.abs(b-x);

    if(da != db)
        return db - da;   // larger distance first
    return b - a;         // larger value first
});
        int n = arr.length;
        for(int i=0; i<n; i++) {
            pq.offer(arr[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.sort(ans);
        return ans;
    }
}