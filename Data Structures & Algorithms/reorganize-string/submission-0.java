class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char x : s.toCharArray()) {
            map.put(x,map.getOrDefault(x,0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(Character x:map.keySet()) {
              pq.offer(x);
        }
        Character last = null;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
              Character top = pq.poll();
              sb.append(top);
              map.put(top,map.get(top) - 1);
              if(last != null && map.get(last) > 0) {
                pq.offer(last);
                
              }
              last = top;
              
        }
        if (sb.length() != s.length())
    return "";

return sb.toString();
    }
}