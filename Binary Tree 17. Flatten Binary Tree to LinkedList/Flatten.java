class Solution {
    public void flatten(TreeNode root) {
        if(root==null|| (root.left==null && root.right==null))
            return;
        if(root.left!=null){
            flatten(root.left);
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;

            TreeNode t=root.right;
            while(t.right!=null)
                t=t.right;
            t.right=temp;
        }
        flatten(root.right);
    }
}