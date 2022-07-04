https://www.interviewbit.com/problems/maximum-sum-combinations/

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
     PriorityQueue<Integer>pq=new PriorityQueue<>();
     Collections.sort(A,Collections.reverseOrder());// BECAUSE WE NEED ONLY MAXIMUM ELEMENT
     Collections.sort(B,Collections.reverseOrder());// BECAUSE WE NEED ONLY MAXIMUM ELEMENT
     for(int i:A){
         for(int j:B){
             int sum=i+j;                           // SUM
             if(pq.size()<C){
                 pq.add(sum);                       // IF PEEK IS SMALL THEN REPLACE IT WITH SUM;
             }else if(pq.peek()<sum){
                 pq.poll();                                     
                 pq.add(sum);
             }else{
                 break;                            //  NO MORE GREATER VALUE LEFT BREAK;
             }
         }
     }
     ArrayList<Integer>ans=new ArrayList<>(pq);
     Collections.sort(ans,Collections.reverseOrder());
     return ans;
    
    }
}
