https://practice.geeksforgeeks.org/problems/subset-sums2234/1
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer>ans=new ArrayList<>();
        rec(arr,N,ans,0,0);
        return ans;
    }
    public void rec(ArrayList<Integer> arr,int n,ArrayList<Integer>ans,int i,int sum){
        if(i==n){
            ans.add(sum);
            return;
        }
       rec(arr,n,ans,i+1,sum+arr.get(i));// taking that sum     /// because this is sum we have to do in that way
       rec(arr,n,ans,i+1,sum);// not taking that sum
    }
}

                
