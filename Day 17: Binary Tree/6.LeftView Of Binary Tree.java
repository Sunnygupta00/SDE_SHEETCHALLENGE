QUSTION : https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
APPRAOCH : ADD ALL NODES LEVEL WISE, LEVEL IS EQUAL TO ANS SIZE THEN ADD IT , BECASE WE NEED FIRST LEFT MOST ELEMENT
           GO LEFT THAN RIGHT 
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans = new ArrayList<>();
      rec(root, ans,0);
      return ans;
    }
    void rec(Node root, ArrayList<Integer>ans, int level){
        if (root == null){
            return;
        }
        if(ans.size() ==  level){
            ans.add(root.data);
        }
        rec(root.left, ans, level+1);
        rec(root.right, ans, level+1);
    }
}
