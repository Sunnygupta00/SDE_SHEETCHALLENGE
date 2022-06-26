//---------------------------------------------BRUTE FORCE---------------------------------------------------------------
// O(KLOGX+ 2^(N)) ->KLOGX--> TO INSERT EVERY UNIQUE SUBSET

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
     Set<List<Integer>>ans=new HashSet<>();     // STORING EVERY POSSIBLE ANS IN SET AS WE KNOW SET STORES ONLY UNIQUE ELEMENT THAT'S WHAT WE NEED :)
        rec(0,nums,nums.length,ans,new ArrayList<>());
        return new ArrayList<>(ans);
    }
    public void rec(int start,int arr[],int n, Set<List<Integer>>ans,List<Integer>temp){
        if(start==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[start]);
        rec(start+1,arr,n,ans,temp);
        temp.remove(temp.size()-1);
        rec(start+1,arr,n,ans,temp);
    }
}
//---------------------------------------------BETTER APPROACH-------------------------------------------------------------
// O(K * 2^(N))
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
     Arrays.sort(nums);                                                   // SORTING TO AVOID DUPLICATES i.e nums[i]==nums[i-1]
        List<List<Integer>>ans=new ArrayList<>();
        rec(0,nums,nums.length,ans,new ArrayList<>());
        return ans;
    }
    public void rec(int start, int arr[], int n, List<List<Integer>>ans,List<Integer>temp){
       ans.add(new ArrayList<>(temp));                                   // CONSIDERING EVERY POSSIBLE VALUE
        for(int i=start;i<n;i++){
            if(i>start && arr[i]==arr[i-1])continue;// IN ANOTHER ITERATION IF ARR[I]==ARR[I-1] SKIP IT // ADDING ONLY UNIQUE ELEMENT TO AVOID DUPLICATES
            temp.add(arr[i]);
            rec(i+1,arr,n,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}
