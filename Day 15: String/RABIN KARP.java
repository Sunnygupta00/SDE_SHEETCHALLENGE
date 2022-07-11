======================================================================================================================
                          QUESTION : https://leetcode.com/problems/repeated-string-match/submissions/
======================================================================================================================

class Solution {
    public int repeatedStringMatch(String a, String b) {
      // BRUTE FORCE
        int count=1;
        StringBuilder text=new StringBuilder(a);
        while(text.length()<b.length()){
           count++;
            text.append(a);
        }
        if(findPat(text.toString(),b))return count;
        text.append(a);
        if(findPat(text.toString(),b))return count+1;
        
        return -1;
        
    }
    public boolean findPat(String a, String b){ // THIS IS RABIN KARP ALGO :)
        int n=a.length();
        int m=b.length();
        int maxChar=256,prime=101,highestPow=1;
        for(int i=0;i<m-1;i++){// calculating highest power of polynomial fuction
            highestPow=(highestPow*maxChar)%prime; 
        }
        int textHash=0;
        int patHash=0;
        
//----------------------------------------------------------------------------------
        
        for(int i=0;i<m;i++){       // Calculated hashfor both text and pattern
            textHash=(textHash*maxChar+a.charAt(i))%prime;
            patHash=(patHash*maxChar+b.charAt(i))%prime;
        }
        
//----------------------------------------------------------------------------------        
        for(int i=0; i<n-m+1; i++){
            
            if(patHash==textHash){
                boolean check=true;
                for(int j=0; j<m; j++){
                    if(a.charAt(i+j)!=b.charAt(j)){
                        check=false;
                        break;
                    }
                }
                if(check){
                    return true;
                }
            }
            if(i<n-m){
                textHash = (textHash-highestPow*a.charAt(i));// Substracting first temp of window
                textHash=(textHash*maxChar)%prime; // increasing power for next window;
                textHash=(textHash+a.charAt(i+m))%prime;// adding next window element
                if(textHash<0)textHash+=prime;
            }
            
        }
        
        return false;
    }
}
