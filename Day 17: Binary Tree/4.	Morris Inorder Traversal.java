QUESTION : DO IN ORDER IN CONSTANT SPACE
APPROACH : (LEFT , ROOT , RIGHT)
           1)IF LEFT IS NULL, THEN ADD ROOT TO ANS AND GO RIGHT
           2)ELSE MAKE JUGAD TO COMEBACK AFTER LEFT SUBTREE, SO GO LEFT'S EXTREME RIGHT
           3) IF RIGHT IS NULL SO MAKE CONNECTION, AND GO LEFT FOR MORE CONNECTION
           4) IF THERE IS ALREADY A CONNECTION MEANS LEFT PART IS DONE, ADD ROOT , BREAK CONNECTION AND GO RIGHT
           
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right; // BHAI LEFT NULL HAI RIGHT SIDE DEKH lo
            }else{
                TreeNode prev = curr.left; // left ke baad root pr ane ka jugad
                while(prev.right !=null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null) { // malab hamne connection nahi banaya
                    prev.right = curr;
                    curr = curr.left ;// now go for next left 
                }else{      // means mera connection bana hua hai, means i have visited left side, so break the connection and go right
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
                
            }
        }
        return ans;
    }
}
