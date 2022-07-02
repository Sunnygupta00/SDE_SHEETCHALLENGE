https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1/#
class Solution 
{
    //Function to find minimum number of pages.
   int findPages(int A[], int N, int M) 
   {
       int sum=0;
       for(int i:A)sum+=i;
       int start=A[N-1];                                         // MINIMUM EK BOOK TOH PADEGA HI
       int end=sum;
       int res=-1;
       while(start<=end){
           int mid=start+(end-start)/2;
            if(isValid(A,mid,M)){
                res=mid;
                end=mid-1;                                      // FINDING MINIMUM
            }else{
                start=mid+1;                                    // increase the capacity of reading
            }
       }
       return res;
   }
  public boolean isValid(int arr[],int mid, int C){
      int student=1;
      int page=0;
      for(int i:arr){
           page+=i;
           if(page>mid){
               student++;                                     // NEED MORE STUDENTS FOR READING
               page=i;
           }
           if(student>C){
               return false;
           }
      }
      return true;
  } 
 
