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
