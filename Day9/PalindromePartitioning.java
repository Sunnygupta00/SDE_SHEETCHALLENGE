//https://leetcode.com/problems/palindrome-partitioning/submissions/
// TIME COMPLEXITY O(N*2^(N))
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        rec(0,s,s.length(),ans,new ArrayList<>());
        return ans;  
    }
    public void rec(int start,String s,int n,List<List<String>>ans,List<String>temp){
        if(start==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int end=start;end<n;end++){
            String Substring=s.substring(start,end+1); // taking substring from start to i+1 if it is valid  Pallindrome take it or ignore it
            if(isPall(Substring)){
                temp.add(Substring);                 // choose
                rec(end+1,s,n,ans,temp);
                temp.remove(temp.size()-1);           // unchoose and backtrack
            }
        }
    }
    public boolean isPall(String s){
        int start=0;int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
