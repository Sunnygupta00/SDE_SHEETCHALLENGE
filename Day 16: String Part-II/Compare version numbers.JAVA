======================================================================================================================
                          QUESTION : https://leetcode.com/problems/compare-version-numbers/
======================================================================================================================
class Solution {
    public int compareVersion(String one, String two) {
        int n=one.length();
        int m=two.length();
        int i=0,j=0;   
        while(i<n || j<m){
              int first=0;int second=0;
            while(i<n && one.charAt(i)!='.'){
                first=first*10+one.charAt(i++)-'0'; // COUNTING DIGITS
            }
            while(j<m && two.charAt(j)!='.'){
                second=second*10+two.charAt(j++)-'0'; // COUNTING DIGITS
            }
            if(first!=second){
               return Integer.compare(first,second);  // COMPARE
            }else{
                i++;
                j++;
            }
            
        }
        return 0;// MEANS EQUAL
        
    }
}
