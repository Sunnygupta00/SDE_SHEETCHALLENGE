===========================================================================================================================
                      QUESTION: https://practice.geeksforgeeks.org/problems/search-pattern0205/1#
===========================================================================================================================

class Solution
{ 
    ArrayList<Integer> search(String p, String t)
    {
        ArrayList<Integer>ans=new ArrayList<>();
        int n=t.length();
        int m=p.length();
        char [] pat=p.toCharArray();
        char [] txt = t.toCharArray();
        int lps[]=new int[m];
        // CALCULATING LPS --> LONGEST COMMON PREFIX SUFFIX FOR PATTERN
        int j=0;int i=1;
        while(i<m){
            if(pat[i]==pat[j]){
                lps[i]=++j;
                i++;
            }else{
                   if(j>0){
                       j=lps[j-1];// we are sending j behind that value which is prefix suffix of that char
                   }else{
                       lps[i]=j;// default 0 rahega j
                       i++;
                   }
            }
        }
        //for(int k: lps)System.out.print(k+" ");
        j=0;i=0; //NOW ITS TIME TO ITERATE ON BOTH THE STRING i on txt and j on pat
        while(i<n){
            // STEP 1: IF PATTERN MATCH
            if(txt[i]==pat[j]){
                i++;
                j++;
            }else{  // STEP 2 : IF NOT MATCH
                  
                   if(j>0){// STEP 3 : IF J IS GREATER THAN MEANS THERE IS SOME PREFIX AVAILABLE, SO ITERATE BEHIND
                       j=lps[j-1];
                   }else{     // STEP 4 : ELSE MOVE AHEAD 
                       i++;
                   }
            }
            if(j==m)  // STEP 5 ; IF WE HAVE J==M MEANS WE GOT THE PATTERN
            {
                ans.add(i-m); // INDEX OF THAT ELEMENT
                j=lps[j-1]; // moving j behind BECAUSE FOR TXT : AAAAAAAA AND PAT : AA ANS WILL BE -> 012345 other wise it will give 0246
            }
        }

        return ans;
    }
    
}
