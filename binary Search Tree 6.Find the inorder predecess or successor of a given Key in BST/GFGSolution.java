/*
Root is the given key: In this case, if the left subtree is not NULL, then predecessor is the rightmost node in 
left subtree and if right subtree is not NULL, then successor is the leftmost node in right subtree.

Root is greater than key: In this case, the key is present in left subtree of root. So search for the key in left
subtree by setting root = root->left. Note that root could be an inorder successor of given key. In case the key
has no right subtree, the root will be its successor.


Root is less than key: In this case, key is present in right subtree of root. So search for the key in right
subtree by setting root = root->right. Note that root could be an inorder predecessor of given key. In case
the key has no left subtree, the root will be its predecessor. 
*/

import java.util.*; 
class GFG 
{ 

// BST Node 
static class Node 
{ 
	int key; 
	Node left, right; 
}; 
static Node pre; 
static Node suc; 

// Function that finds predecessor 
// and successor of key in BST. 
static void findPreSuc(Node root, int key) 
{ 
	if (root == null) 
		return; 

	// Search for given key in BST. 
	while (root != null) 
	{ 

		// If root is given key. 
		if (root.key == key) 
		{ 

			// the minimum value in right subtree 
			// is predecessor. 
			if (root.right != null) 
			{ 
				suc = root.right; 
				while (suc.left != null) 
					suc = suc.left; 
			} 

			// the maximum value in left subtree 
			// is successor. 
			if (root.left != null) 
			{ 
				pre = root.left; 
				while (pre.right != null) 
					pre = pre.right; 
			} 
			return; 
		} 

		// If key is greater than root, then 
		// key lies in right subtree. Root 
		// could be predecessor if left 
		// subtree of key is null. 
		else if (root.key < key) 
		{ 
			pre = root; 
			root = root.right; 
		} 

		// If key is smaller than root, then 
		// key lies in left subtree. Root 
		// could be successor if right 
		// subtree of key is null. 
		else
		{ 
			suc = root; 
			root = root.left; 
		} 
	} 
} 

// A utility function to create a new BST node 
static Node newNode(int item) 
{ 
	Node temp = new Node(); 
	temp.key = item; 
	temp.left = temp.right = null; 
	return temp; 
} 

// A utility function to insert 
// a new node with given key in BST 
static Node insert(Node node, int key) 
{ 
	if (node == null) 
		return newNode(key); 
	if (key < node.key) 
		node.left = insert(node.left, key); 
	else
		node.right = insert(node.right, key); 
	return node; 
} 

// Driver Code 
public static void main(String[] args) 
{ 
	int key = 65; // Key to be searched in BST 

	/* Let us create following BST 
				50 
				/ \ 
			/ \ 
			30	 70 
			/ \	 / \ 
			/ \ / \ 
		20 40 60 80 
	*/
	Node root = null; 
	root = insert(root, 50); 
	insert(root, 30); 
	insert(root, 20); 
	insert(root, 40); 
	insert(root, 70); 
	insert(root, 60); 
	insert(root, 80); 

	findPreSuc(root, key); 
	if (pre != null) 
		System.out.println("Predecessor is " + 
									pre.key); 
	else
		System.out.print("-1"); 

	if (suc != null) 
		System.out.print("Successor is " + suc.key); 
	else
		System.out.print("-1"); 
	} 
} 

