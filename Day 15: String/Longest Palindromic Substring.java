=========================================== BRUTE FORCE O(N*N*N) ===============================================
class Solution {
    public String longestPalindrome(String s) {
     int n=s.length();
       if(n==1|| n==0)return s;
        List<String>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
             if(isValid(s,i,j)){
                 ans.add(s.substring(i,j+1));
              }           
            }
        }
        Collections.sort(ans,(a,b)->a.length()-b.length());
        //for(String i: ans)System.out.println(i);
        return ans.get(ans.size()-1);
    }
    public boolean isValid(String s,int i, int j){
       while(i<j)if(s.charAt(i++)!=s.charAt(j--))return false;
       return true;
    }
    
}
