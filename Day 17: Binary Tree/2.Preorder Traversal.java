QUESTION : https://leetcode.com/problems/binary-tree-preorder-traversal/
APPROACH : (ROOT, LEFT, RIGHT)
           1)SO FIRST ADD IT TO ANS
           2)THEN GO RIGHT,
           3)THEN GO LEFT, HENCE IT IS STACK SO WE WANT LEFT ON TOP THAT'S WHY INSERTING LEFT LAST

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
       Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(stack.size()>0){
            TreeNode temp= stack.pop();  
            ans.add(temp.val);            //1) ROOT
            if(temp.right!=null){        // 3) RIGHT
                stack.push(temp.right);
            }
            if(temp.left!=null){        //2) LEFT
                stack.push(temp.left);
            }
        }
        return ans;
    }
}
