========================================================================================================================
                     QUESTION : https://leetcode.com/problems/sliding-window-maximum/submissions/
========================================================================================================================
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int p=0;
        int ans[]=new int[n-k+1];
        int i=0;
        int j=0;
        Deque<Integer>q=new ArrayDeque<>();
        while(j<n){
            while(q.size()>0 && nums[j]>q.peekLast()){
                q.pollLast();                  // REMOVING SMALLER ELEMENT FROM BACK
            }q.offerLast(nums[j]);                // ADDING  GRATER ELEMENT
            
            if(j-i+1<k){
                j++;
            }else{
                ans[i]=q.peek();
                if(nums[i]==q.peek()){
                     q.pollFirst();        // AS WE HAVE ADDED GREATER ELEMENT IN FIRST, 
                                           //THFORE WE WILL COMPARE FIRST ELEMENT AND THEN POP IT
                }
                i++;j++;
            }
        }
        return ans;
        
    }
}
========================================================================================================================
========================================================================================================================  
