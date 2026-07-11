class Solution {
    public static class Pair {
        int profit;
        int capital;

        Pair(int profit,int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> capitalQ = new PriorityQueue<>((a,b) -> a.capital - b.capital);
        PriorityQueue<Pair> profitQ = new PriorityQueue<>((a,b) -> b.profit - a.profit);
        int n = profits.length;
        for(int i=0; i<n; i++) {
            capitalQ.offer(new Pair(profits[i],capital[i]));
        }
        int toComplete = k;
        while(k > 0) {
            while(!capitalQ.isEmpty() && w >= capitalQ.peek().capital) {
                profitQ.offer(capitalQ.poll());
            }
            if(profitQ.isEmpty()) {
                return w;
            }
            w += profitQ.poll().profit;
            k--;
        }
        return w;
    }
}