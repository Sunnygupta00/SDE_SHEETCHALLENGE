===================================BRUTE FORCE USING PRIORITY QUEUE O(KLOGN)+O(K)===============================================



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer>hm=new HashMap<>();
       for(int i:nums){                                                // ADDING VALUES IN HASHMAP
           hm.put(i,hm.getOrDefault(i,0)+1);
       }
        PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>((a,b)->(a.getValue()-b.getValue())); 
                                                            // PUTING ENTRY OF HASHMAP IN MINHEAP
       for(Map.Entry<Integer,Integer>i:hm.entrySet()){     // ITERAING HASHMAP
           if(pq.size()<k){                                // ADDING FIRST K ELEMENTS
               pq.add(i);
           }else if(pq.peek().getValue()<i.getValue()){    // TAKING RECORD OF MAXIMUM
               pq.poll();
               pq.add(i);
           }
       }
       int ans[]=new int[k];
       for(int i=0;i<ans.length;i++){
           ans[i]=pq.poll().getKey();
       }
        return ans;
        
    }
}


================================================ OPTIMISED O(N)+O(N) ===================================================================
EXPLANATION : https://leetcode.com/problems/top-k-frequent-elements/discuss/1927648/One-OF-THE-best-EXPLANATION
 //USING BUCKET SORT : 
                      HINT: CREATING THE BUCKET OF VALUE WIST THEN ITERING FROM BACK AND PUTTING IN ANS
                     ------------------------------------------------------------------------------------
  class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer>mp=new HashMap<>();
        for(int i:nums){                                            // PUTING ALL THE VALUES IN HM
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        List<Integer>[]bucket= new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer>entry: mp.entrySet()){
            if(bucket[entry.getValue()]==null){      
                bucket[entry.getValue()]=new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());          // ADDING VALUES IN BUCKET
        }
        int ans[]=new int[k];                                      // FOR K UNIQUE ELEMENT
        int index=0;
        for(int i=bucket.length-1;i>=0;i--){                        // ITERAING BUCKETS
            if(bucket[i]!=null){
                for(int pp: bucket[i]){
                    ans[index++]=pp;
                    if(index==k)return ans;
                }
            }
        }
        return ans;
       
           
    }
}
