//-----------------------------------------BRUTE FORCE APPROACH---------------------------------------------------------
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>>ans=new HashSet<>(); // STORING EVERY POSSIBLE SUBSET WHICH IS EQUAL TO TARGET  
        Arrays.sort(candidates);                  // sorting to avoid duplicates
        rec(0,candidates,candidates.length,target,new ArrayList<>(),ans);
        return new ArrayList<>(ans);
        }
    public void rec(int i,int arr[],int n,int target,List<Integer>temp,HashSet<List<Integer>>ans){
        if(i==n || target<=0 ){
            if(target==0)ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        rec(i+1,arr,n,target-arr[i],temp,ans);
        temp.remove(temp.size()-1);
        rec(i+1,arr,n,target,temp,ans);
    }
}
//-----------------------------------------------------BETTER APPROACH-------------------------------------------------
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);                   // sorting to avoid duplicates
       List<List<Integer>>ans=new ArrayList<>();
        rec(0,candidates,candidates.length,target,ans,new ArrayList<>());
        return ans;
    }
    public void rec(int start, int arr[], int n, int target,List<List<Integer>>ans, List<Integer>temp){
        if(start==n || target<=0){
            if(target==0)ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<n;i++){                         // taking every possible value;
            if(i>start && arr[i-1]==arr[i])continue;      // can't take duplicates continuosly
            temp.add(arr[i]);       
            rec(i+1,arr,n,target-arr[i],ans,temp);
            temp.remove(temp.size()-1);                  // backtracking
        }
    }
   
}
