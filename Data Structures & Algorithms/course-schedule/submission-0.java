class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites) {
            int toDo = pre[0];
            int preq = pre[1];
            adjList.get(preq).add(toDo);
            indegree[toDo]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
               if(indegree[i] == 0) {
                queue.offer(i);
               }
        }
        List<Integer> canFinish = new ArrayList<>();
        while(!queue.isEmpty()) {
            int finished = queue.poll();
            canFinish.add(finished);
            for(int neigh: adjList.get(finished)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }
        int size = canFinish.size();
        return size == numCourses? true:false;
    }
}
