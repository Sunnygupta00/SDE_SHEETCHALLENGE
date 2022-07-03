if we classify it into priority queue 
                     1)we need one large pq for left element (it will contain only small values)
                      2) we need one small pq for right element  (it will contain only bigh values)         

class MedianFinder {
    PriorityQueue<Integer>large= new PriorityQueue<>();
    PriorityQueue<Integer>small=new PriorityQueue<>((a,b)->b-a);
    public MedianFinder() {}
    
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());// adding minimum element
        if (large.size() < small.size()) // balance
            large.add(small.poll());
    }
    
    public double findMedian() {
         return large.size() > small.size()            // if size is odd return left one (LARGE) else small
               ? large.peek()
               : (large.peek() + small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
