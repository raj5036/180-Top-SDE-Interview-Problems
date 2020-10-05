import java.util.*;

public class LCA{
	TreeNode lca(TreeNode root,int n1, int n2){
		if(root == null)
			return root;
		if(root.data<n1 && root.data<n2)
			return lca(root.right,n1,n2);
		if(root.data>n1 && root.data>n2)
			return lca(root.left,n1,n1);
		return root;
	}
}