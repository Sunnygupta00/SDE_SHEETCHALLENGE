QUESTION : https://leetcode.com/problems/binary-tree-inorder-traversal/
APPROACH : 1) LEFT ROOT RIGHT 
           2) SO INSERT ALL LEFT, IF FOUND NULL POP IT AND ADD TO ANS THEN GO RIGHT

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer>ans=new ArrayList<>();   
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while(root!=null || stack.size()>0){
            if(root!=null){
                stack.push(root);
                root=root.left;               // <-------LEFT
            }else{
                TreeNode temp= stack.pop();
                ans.add(temp.val);            //<--------ROOT
                root=temp.right;              //<------- RIGHT 
            }
        }
        return ans;
        
    }
}
