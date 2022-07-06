class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         Stack<Integer>stack=new Stack<>();
         HashMap<Integer,Integer>hm=new HashMap<>();          // FOR STORING 
        for(int i=nums2.length-1;i>=0;i--){                  // ITERAING FROM BACK 
            while(stack.size()>0 && stack.peek()<nums2[i]){ // POPING ALL SMALLER VALUE BECAUSE WE NEED ONLY GREATER VALUES
                stack.pop();
            }
            if(stack.size()>0){
               hm.put(nums2[i],stack.peek());
            }else{
                hm.put(nums2[i],-1);      // NOT FOUND
            }
            stack.push(nums2[i]);
        }
       int ans[]=new int[nums1.length];
        
        for(int i=0;i<ans.length;i++){                  
            ans[i]=hm.get(nums1[i]);
        }
        return ans;
        
    }
}
