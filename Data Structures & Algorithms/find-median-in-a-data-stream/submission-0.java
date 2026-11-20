class MedianFinder {
       PriorityQueue<Integer> fh = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> sh = new PriorityQueue<>();
        int count = 0;
    public MedianFinder() {
      
    }
    
    public void addNum(int num) {
        if(fh.isEmpty() || num <= fh.peek()) {
            fh.offer(num);
        }
        else{
            sh.offer(num);
        } // on empty heaps one num can satisfy both 
        if(sh.size() > fh.size()) {
            fh.offer(sh.poll());
        }
        if(fh.size() > sh.size() + 1) {
            sh.offer(fh.poll());
        }
        count++;
        
    }
    
    public double findMedian() {
        if(count%2 == 0) {
            return (fh.peek() + sh.peek())/2.0;
        }
        else {
            return (double)fh.peek();
        }
    }
}
