===================================================================================================================
      QUESTION : https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
===================================================================================================================
   BRUTE FORCE: O(N*N)
     ```
    public class Solution {
    public int solve(String A) {
        
     int length=A.length()-1;
     for(int i=0;i<A.length();i++){
         if(isPall(A,0,length-i)){
             return i;
         }
     }
     return -1;
     
    }
---------------------------------------------------------------------------------------------------------------    
    public boolean isPall(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;     // CHEKING PALLINDROME
        }
        return true;
    }
}

     ```
===================================================================================================================     
     OPTIMISED APPROACH USING LPS --> LET S=RACECAR TO CHECK THIS WE NEED 
                                      A= [ R A C E C A R # R A C E C A R ]     // EXPLANATION
                                    LPS= [ 0 0 0 0 0 0 0 0 1 2 3 4 5 6 7 ]
                                     RETURN S.LENGHT()-LPS[LPS.LENGTH-1] --> 0 SWAPS REQUIRED
 ---------------------------------------------------------------------------------------------------------------
       TIME COMPLEXITY O(N+M) SPACE O(N+M)
 ---------------------------------------------------------------------------------------------------------------      
       public class Solution {
    public int solve(String A) {
     int length=A.length();
     String s= A;
     s=s+"#"+reverse(s.toCharArray());  // REVERSE
     //System.out.println(s);
     int lps[]=lps(s.toCharArray());     //LPS
     return length-lps[lps.length-1];   //ANS
    }
---------------------------------------------------------------------------------------------------------------         
    public String reverse( char[]arr){
        int i=0,j=arr.length-1;
        while(i<j){                                         // REVERSING
            swap(arr,i++,j--);
        }
        return new String(arr);
    }
---------------------------------------------------------------------------------------------------------------         
    public void swap(char arr[],int i,int j){
        arr[i]^=arr[j];                                      // SWAPING
        arr[j]^=arr[i];
        arr[i]^=arr[j];
    }
  ---------------------------------------------------------------------------------------------------------------       
    public int []lps( char pat[]){
        int i=1,j=0;
        int m=pat.length;
        int ans[] = new int[m];
        while(i<m){
            if(pat[i]==pat[j]){                                   // CALCULATING LPS
                ans[i]=++j;
                i++;
            }else{
                if(j>0){
                    j=ans[j-1];
                }else{
                    i++;
                }
            }
        }
        return ans;
    }
}
