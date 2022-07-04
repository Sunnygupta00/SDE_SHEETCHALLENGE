public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> a) {
        Queue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });
    
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(ArrayList<Integer> l: a){
            pq.offer(l);
        }
        while(!pq.isEmpty()){
            ArrayList<Integer> curr = pq.poll();
            list.add(curr.get(0));
            if(curr.size()>1){
                pq.offer(new ArrayList<Integer>(curr.subList(1,curr.size())));
            }
        }
        return list;
    }
}
