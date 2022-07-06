=========================================================================================================================
                 QUESTION : https://leetcode.com/problems/largest-rectangle-in-histogram/
=========================================================================================================================

class Solution {
 ------------------------------------------------------------------------------------------------------ 
    public int largestRectangleArea(int[] heights) {
        int ans=0;
        int []leftSmall= leftSmaller(heights);
        int []rightSmall= rightSmaller(heights);
       // for(int i:leftSmall)System.out.print(i+" ");
        //System.out.println();                         // DEBUG :)
       // for(int i:rightSmall)System.out.print(i+" ");
        int width[]=new int[heights.length];
        for(int i=0;i<width.length;i++){       
            width[i]=rightSmall[i]-leftSmall[i]-1;    // WIDTH =R-L-1;
            ans=Math.max(ans,heights[i]*width[i]);
        }
        
        return ans;
    }
------------------------------------------------------------------------------------------------------  
    public int[] leftSmaller (int arr[]){  // CALCULATING LEFT SMALLER  
        int ans[]=new int[arr.length];
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            while(stack.size()>0 && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            ans[i]= (stack.size()>0) ? stack.peek() : -1 ;
            stack.push(i);
        }
        return ans;
    }
------------------------------------------------------------------------------------------------------
    
    public int[] rightSmaller(int arr[]){// CALCULATING RIGHT SMALLER
         int ans[]=new int[arr.length];
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            while(stack.size()>0 && arr[stack.peek()]>arr[i]){
                ans[stack.pop()]=i;
            }
            stack.push(i);
        }
        while(stack.size()>0)ans[stack.pop()] = arr.length; 
        return ans;
    } 
}
=========================================================================================================================


