//TIME COMPLEXITY O(N*N) [ITERATE + DELETION]
//SPACE O(N) TO STORE [1 TO N ]
class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer>temp=new ArrayList<>();
        for(int i=1;i<n;i++){
            fact*=i;
            temp.add(i);
        }
        temp.add(n);
    //[1,2,3,4] if n==4
  // WE ARE DOING 0 BASED INDEXING SO WE HAVE TO REDUCE K ALSO
        k=k-1;
        StringBuilder sb=new StringBuilder();
        while(true){
            int index= k/fact;
            sb.append(String.valueOf(temp.get(index)));// taking index and converting it into string i.e FOR N=4 AND K=16 , "3"+SUBSET [1,2,4] 
            temp.remove(index);                        // removing that index
            if(temp.size()==0){                        // if every number is taken then break
                break;
            }
            k=k%fact;// remaining combination;
            fact=fact/temp.size();// decreasing fact;
        }
        return sb.toString();
        
    }
}
