===================================================================================================================
                               QUESTION : https://leetcode.com/problems/count-and-say/

===================================================================================================================

class Solution {
    public String countAndSay(int n) {
        String s="1";
        if(n==1)return s;
      for(int i=0;i<n-1;i++){
            s=count(s);            // APPLING THAT OPPERATION N TIME
         
      }
        return s;
    }
   public String count(String s){
      StringBuilder sb=new StringBuilder();
       char c=s.charAt(0);
       int count=1;                       // INITIAL COUNT 1
       for(int i=1;i<s.length();i++){
           if(s.charAt(i)==c){
               count++;                     // COUNTING OCCURENCES
           }else{
               sb.append(count+""+c);
               c=s.charAt(i);
               count=1;                     // SETING DEFAULT
           }
       }
       sb.append(count+""+c);
       return sb.toString();
   }       
}
