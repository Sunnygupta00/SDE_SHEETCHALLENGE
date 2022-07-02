// HENCE GIVEN N*M IS ALWAYS ODD MEANS THERE WILL BE ONLY ONE MIDDLE
// IF ANY ELEMENT HAVE (MID-1) ELEMENTS SMALL MEANS IT IS MID
// WE ARE FINDING COUNT OF EVERY MID ELEMENT IF IT IS EQUAL TO MID MEANS IT IS THE POSSIBLE ANS
// TIME COMPLEXITY O(ROW LOG COL)
public class Solution {
    public int findMedian(int[][] A) {
        int n=A[0].length;
        int m=A.length;
        int TotalElement=n*m;
        int ElementBefore=(TotalElement)/2;
        int start=0;
        int end=(int)1e9;                            // WHY 1E9? BECAUSE ELEMENT DOES'T DEPEND ON SIZE OF ARRAY 
                                                     //           IT DEPENDS ON SIZE OF INTEGER 
                                                     // EX : ARR SIZE = 7 AND MEDAIN CAN BE 100000 SO THAT'S WHY WE ARE DOING THIS
        while(start<=end){
            int mid=start+(end-start)/2;
            int count=0;
            for(int i=0;i<m;i++){
                count+=bs(A[i],mid);               // COUNTING VALUE PRESENT BEFORE THE ELEMENT
            }
            if(count>ElementBefore){                // IF COUNT IS HIGH MEANS MID IS BEFORE IT
                end=mid-1;
            }else{
                start=mid+1;                        // IF COUNT IS LOW MEANS MID IS AFTER THAT
            }
        }
        return start;
        
    }  
    public int bs(int arr[],int x){            // CALCULATING THE VALUES PRESENT BEFORE MID
           int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=x){
               start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
