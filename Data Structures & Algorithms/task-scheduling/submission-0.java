class Solution {
    public static class Pair {
        char task;
        int freeTime;

        Pair(char task,int freeTime) {
            this.task = task;
            this.freeTime = freeTime;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char task: tasks) {
            map.put(task,map.getOrDefault(task,0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            int comp = map.get(b.task) - map.get(a.task);
            if(comp == 0) {
                return a.task-b.task;
            }
            return comp;
        });
        for(Character x: map.keySet()) {
            pq.offer(new Pair(x,0));
        }
        int cycles = 0;
        
        
        while(!pq.isEmpty() || !queue.isEmpty()) {
            while(!queue.isEmpty() && cycles >= queue.peekFirst().freeTime) {
                pq.offer(queue.pollFirst());
            }
            if(!pq.isEmpty()) {
                Pair p = pq.poll();
                map.put(p.task,map.get(p.task) - 1);
                p.freeTime = cycles + n+1;
                if(map.get(p.task) > 0) {
                    queue.addLast(p);
                }
            }
            cycles++;
        }

        return cycles;
    }
}
