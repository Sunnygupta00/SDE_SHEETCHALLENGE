public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<A.size();i++)
        {
            for(int j=0;j< B.size(); j++)
            {
               int sum= A.get(i)+B.get(j);
               if(pq.size()<C)
               {
                   pq.add(sum);
               }
               else 
               {
                   if(sum>pq.peek())
                   {
                       pq.poll();
                       pq.add(sum);
                   }
                   else if(sum<pq.peek())
                   {
                      break; 
                   }
               }
            }
        }
       
       while(!pq.isEmpty())
       {
           arr.add(pq.peek());
           pq.poll();
       }
       Collections.sort(arr, Collections.reverseOrder());
       
       return arr;
    }
}

