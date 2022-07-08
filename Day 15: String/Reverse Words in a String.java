=========================================================================================================================
              QUESTION LINK : https://leetcode.com/problems/reverse-words-in-a-string/submissions/
========================================================================================================================

class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        if(n<=1)return s;
        char []arr=s.toCharArray();
        int start=0;
        for(int i=0;i<n;i++){
            if(arr[i]==' '){
                reverse(arr,start,i-1);
                start=i+1; // start after that space
            }
        }
        if(start<n)reverse(arr,start,n-1);
        reverse(arr,0,n-1);
        return removeSpace(arr,n);
        
    }
    public String removeSpace(char arr[],int n){
        int i=0;
        int j=0;
        while(j<n){
            while(j<n && arr[j]==' ')j++;// skip starting white spaces
            while(j<n && arr[j]!=' ')arr[i++]=arr[j++];// move characters ahead
            while(j<n && arr[j]==' ')j++;// skip spaces
            if(j<n)arr[i++]=' ';  // if j if not crosed then add space
        }
        return new String(arr).substring(0, i);
    }
    public void reverse(char arr[],int i,int j){
        while(i<j){
          swap(arr,i++,j--);       
        }
    }
    public void swap(char arr[],int i,int j){
        arr[i]^=arr[j];
        arr[j]^=arr[i];
        arr[i]^=arr[j];
    }
}
