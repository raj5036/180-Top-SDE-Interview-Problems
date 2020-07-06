import java.util.*;
class Node{
	int data;
	Node left,right;
	Node(int x){
		this.data = x;
		this.left = this.right=null;
	}
}
class Tree{
	Node root;
	Tree(){
		root=null;
	}
	Node insertNode(Node root,int data){
		if(root == null) return new Node(data);
		else if(data<root.data)
			root.left=insertNode(root.left,data);
		else
			root.right=insertNode(root.right,data);
		return root;
	}
	void inOrder(Node root){
		if(root!=null){
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	void leftView(Node root){
		if(root==null)
			return;
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int i=0;
			while(i++<queue.size()){
				Node current=queue.poll();
				if(i==1)
					System.out.print(current.data+" ");
				if(current.left!=null) queue.add(current.left);
				if(current.right!=null) queue.add(current.right);
			}
		}
	}
}
class TopView2{
	public static void main(String[] args){
		Tree bst=new Tree();
		Node root=bst.insertNode(bst.root,12);
		for(int data=1;data<=10; data++)
			bst.insertNode(root,data);
		bst.inOrder(root);
		bst.leftView(root);
	}
}