--------------------------------------------------------------------------------------------------------------------------
QUESTION 1: https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1#
--------------------------------------------------------------------------------------------------------------------------
QUESTION 2: https://leetcode.com/problems/online-stock-span/
--------------------------------------------------------------------------------------------------------------------------
  
TRICK 1 : TAKING RECORD PREVIOUS INDEX OF  PREVIOUS GREATER ELEMENT ( WE CAN EASILY CALCULATE USING i-greaterINDEX)
  public static int[] calculateSpan(int price[], int n)
   {
       // Your code here
       int[] ans = new int[n];
       Stack<Integer> s = new Stack<>();
       for(int i=0;i<n;i++){
           while(!s.isEmpty() && price[s.peek()]<=price[i] ){   // TAKING RECORD OF PREVIOUS GREATER ELEMENT
               s.pop();
           }
           if(s.isEmpty()){
               ans[i]=i+1;
           }
           else{
               ans[i] = i-s.peek();                           // CALCULATING DIFFERENCE BETWEEN THEM 
           }
           s.push(i);
       }
       return ans;
   }
--------------------------------------------------------------------------------------------------------------------------
  TRICK 2 : TAKING RECORD OF COUNT OF GREATER ELEMENT BEFORE IT
  
   public static int[] calculateSpan(int arr[], int n)
   {
       // Your code here
       int ans[]=new int[n];          // [ ELEMENT , NO OF GREATER ELEMENT 
       Deque<int[]> stack= new ArrayDeque<>();
       for(int i=0;i<n;i++){
           int res=1;                         // INITIAL SPAM         
           while(stack.size()>0 && stack.peek()[0]<=arr[i]){ // CALUCLATION NO OF SMALLER SPAN           
               res+=stack.pop()[1];                                     |
           }
           ans[i]=res;
           stack.push(new int[]{arr[i],res});
           
       }
       return ans;
   }

 --------------------------------------------------------------------------------------------------------------------------
