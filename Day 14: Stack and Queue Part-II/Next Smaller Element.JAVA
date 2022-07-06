public class Solution {
    public int[] prevSmaller(int[] a) {
          int r[]=new int [a.length];
         Deque<Integer> d=new ArrayDeque<Integer>();
         for(int i=0;i<a.length;i++)
         {
             while(!d.isEmpty()&&d.peek()>=a[i]) // POPING ALL GREATER ELEMENTS
             {
                 d.pop();
             }
             r[i]=(d.isEmpty()?-1:d.peek());
             d.push(a[i]);
         }
         return r;
   }
}
