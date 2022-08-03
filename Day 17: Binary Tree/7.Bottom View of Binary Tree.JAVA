QUESTION : https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
APPROACH : MAINTAIN LEVEL , THEN ADD LAST VALUE OF THAT LEVEL
   
    public ArrayList <Integer> bottomView(Node root)
    {
        Map<Integer,Node>map = new TreeMap<>();
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(q.size()>0){
           
            int size=q.size();
            
            for(int i=0;i<size;i++){
                 Pair temp= q.poll();
                 Node curr=temp.root;
                 int l=temp.level;
                 map.put(l,curr);                                    // UPDATING TILL LAST NODE
                if(curr.left!=null)q.offer(new Pair(curr.left,l-1));
                if(curr.right!=null)q.offer(new Pair(curr.right,l+1));
            }
        }
    //   for(Map.Entry<Integer,Node>i: map.entrySet()){
    //       System.out.println(i.getKey()+" "+i.getValue().data);
    //   }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Node a : map.values()){
            ans.add(a.data);
        }
        return ans;
    }
   
