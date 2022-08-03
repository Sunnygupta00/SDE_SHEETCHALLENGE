QUSTION : DO PRE ORDER IN CONSTANT TIME
APPROACH : (ROOT, LEFT , RIGHT)
           1)WE FIRST HAVE TO ADD ROOT, THEN GO LEFT SUBTREE AND THEN RIGHT SUBTREE
           2)TO GO IN RIGHT SUB TREE WE HAVE TO MAKE LEFT'S RIGHT MOST NODE WITH ROOT
           3) IF LEFT IS NULL ADD IT TO ROOT
           4) ELSE MAKE CONNECTION AND ADD ROOT, THEN GO LEFT
           5)  IF CONNECTION IS THERE MEANS WE HAVE VISITED LEFT SUBTREE, BREAK CONNECTION AND GO RIGHT
-----------------------------------------------------------------------------------------------------------------

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
       TreeNode curr = root;
        while(curr!= null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
