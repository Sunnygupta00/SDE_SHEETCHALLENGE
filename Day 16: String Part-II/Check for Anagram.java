==============================================================================================================================
                      QUESTION : https://leetcode.com/problems/valid-anagram/
==============================================================================================================================
  
  class Solution {
    public boolean isAnagram(String s, String t) {
       // NOTE ANAGRAM MEANS SAME NO OF FREQUENCIES OF TWO CHARACTER 
        // WE ARE SIMPLY INCREASING FORM ONE SIDE AND DEACREASING FROM ONE SIDE WHICH SHOULD RESULT ZERO IF NOT MEANS IT IS NOT ANAGRAM
        if(s.length()!=t.length())return false;
      
        int []character = new int[256];// TOTAL CHARACTER
        for(int i=0;i<s.length();i++){
            character[s.charAt(i)]++;// INCREASING 
            character[t.charAt(i)]--;// DEACREASING
        }
      
        for(int i=0;i<256;i++){
            if(character[i]!=0)return false; // IF ALL ARE NOT ZERO RETURN FALSE
        }
        return true;
        
    }
}
