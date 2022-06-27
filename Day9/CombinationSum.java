class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        rec(0,candidates,candidates.length,target,ans,new ArrayList<>());
        return ans;        
    }
    public void rec(int start, int arr[],int n,int target,List<List<Integer>>ans,List<Integer>temp){
        if(start==n|| target<=0){                      // if my target <=0 
            if(target==0)ans.add(new ArrayList<>(temp));
            return;
        }
         temp.add(arr[start]);
        rec(start,arr,n,target-arr[start],ans,temp);//taking unlimited amount of data
        temp.remove(temp.size()-1);                 // backtrack
        rec(start+1,arr,n,target,ans,temp);         // just moving ahead
    }
}
