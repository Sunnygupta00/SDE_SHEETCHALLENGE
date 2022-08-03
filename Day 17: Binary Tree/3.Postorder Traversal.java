QUESTION : https://leetcode.com/problems/binary-tree-postorder-traversal/
APPROACH : (LEFT , RIGHT , ROOT)
          1)SO INSERT ALL LEFT 
          2)FOUND NULL GO RIGHT,
          3) IF RIGHT IS NULL POP IT ADD IT TO ANS, IF IT IS RIGHT MOST NODE SO POP ALL

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        if(root == null)return ans;
       Stack<TreeNode>stack = new Stack<>();
        TreeNode curr = root;
        while(stack.size()>0 || curr!=null){
            if(curr!=null){
                stack.push(curr);             // LEFT 
                curr= curr.left;      
            }else{
                TreeNode temp = stack.peek().right;
                if(temp != null){
                    curr = temp;              // RIGHT
                }else{
                    temp = stack.pop();
                    ans.add(temp.val);
                    while(stack.size()>0 && stack.peek().right == temp){
                        temp = stack.pop();
                        ans.add(temp.val);     // ROOT
                    }
                }
                
            }
        }
        return ans;
    }
}
