========================================================================================================================
                            QUESTION : https://leetcode.com/problems/implement-strstr/submissions/
========================================================================================================================


class Solution {
    public int strStr(String txt, String pat) {
        return kmpAlgo(txt.toCharArray(),pat.toCharArray());
     
    }
    public int kmpAlgo(char [] txt, char []pat ){
        int m=pat.length;
        int n=txt.length;
        int lps[] =new int[m];
        int i=1,j=0;
        while(i<m){
            // if found prefix suffix
            if(pat[i]==pat[j]){
                lps[i]=++j;
                i++;
            }else{
                if(j>0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        // now searching on txt;
        i=j=0;
        while(i<n){
            // if found
            if(pat[j]==txt[i]){
                i++;
                j++;
            }else{
                if(j>0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
            // if found 
            if(j==m){
                return i-m;
            }
        }
        return -1;
    }
}
========================================================================================================================
                                           --- USING RABIN AGLO ---
 ========================================================================================================================                                           
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length())return -1;
     return rabin(haystack,needle);   
    }
    
      public int rabin(String txt, String pat){
        int n=txt.length();
        int m=pat.length();
        int prime=101;
        int pow=1;
        int maxChar=256;
        // calculating power 
        for(int i=0; i<m-1; i++){
            pow=(pow*maxChar)%prime;
        }
        int patHash=0;
        int textHash=0;
        // Calculating pat and text(first m ) Hash
        for(int i=0; i<m; i++){
            patHash= (maxChar*patHash + pat.charAt(i))%prime;
            textHash= (maxChar*textHash + txt.charAt(i))%prime;
        }
        // now searching int n-m window;
        for(int i=0; i<n-m+1; i++){
            int j;
            if(patHash==textHash){
                boolean check=true;
                // checking 
                for( j=0; j<m; j++ ){
                    if(txt.charAt(i+j)!=pat.charAt(j)){
                        check=false;
                        break;
                    }
                }
                if(m==j)return i;
            }
            if(i<n-m){// if it is less than last window index;
                
                textHash=   (maxChar*(textHash-pow*txt.charAt(i)) + txt.charAt(i+m)) %prime;
                if(textHash<0)textHash+=prime;
                       
            }
        }
        return -1; // if not found;
    }
}
