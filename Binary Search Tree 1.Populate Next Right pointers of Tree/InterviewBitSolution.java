public class Solution {
    public void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        while (queue.peek() != null) {
            int size = queue.size()-1;
            
            while (size-- > 0) {
                TreeNode node = queue.remove();
                // System.out.println(size+" " +node.val);
                node.next = queue.peek();
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        
            queue.remove();
            queue.add(null);
        }
    }
}