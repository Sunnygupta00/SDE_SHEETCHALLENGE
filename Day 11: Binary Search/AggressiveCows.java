https://leetcode.com/discuss/general-discussion/1302335/aggressive-cows-spoj-fully-explained-c
same problem : https://www.codingninjas.com/codestudio/problems/chess-tournament_981299?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
--------------------------------------------------------------------------------------------------------
  
import java.util.*;
public class Solution {

    public static int chessTournament(int[] arr, int n,  int c) 
	{
        Arrays.sort(arr);                       // most imp
        int start=0;                            // min dif
        int end=arr[n-1]-arr[0];                // maximum differnce
        int res=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(possible(arr,n,mid,c)){
                res=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return res;
    }
    public static boolean possible(int arr[],int n,int mid,int c){
        int chess=1;                     // ek toh rahega hi
        int picked=arr[0];               // initially ek toh pick karega hi
        for(int i=0;i<n;i++){
            if(arr[i]-picked>=mid){
                chess++;                     // need more chess
                picked=arr[i];
            }
            if(chess>=c){
                return true;
            }
        }
        return false;
        
    }

}
