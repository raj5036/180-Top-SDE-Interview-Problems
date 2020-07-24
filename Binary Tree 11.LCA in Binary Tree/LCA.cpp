#include<iostream>
#include<bits/stdc++.h>
#include<stack>
#include<queue>
using namespace std;
class Node{
	int data;
	Node *left,*right;
	public:
	Node(); //default constructor
	Node(int); //Parameterized constructor
	Node* insertNode(Node*,int);
	Node* search(Node*,int);
	void levelOrder(Node*);
	int height(Node*);
};
class BST:public Node{
	Node* root;
	public:
		BST();
};
BST::BST(){
	root=NULL;
}
Node::Node(int x){
	data=x;
	left=right=NULL;
}
Node* Node::insertNode(Node* root,int data){
	if(root==NULL) return new Node(data);
	else if(data<root->data)
		return insertNode(root->left,data);
	return insertNode(root->right,data);
}
Node* Node::search(Node* root,int data){
	if(root->data==data)
		return root;
	else if(data<root->data) return search(root->left,data);
	else 
		return search(root->right,data);
}
void Node::levelOrder(Node* root){
	queue<Node*> q;
	q.push(root);
	while(!q.empty()){
		Node* node=q.front();
		q.pop();
		cout<<node->data<<" ";
		if(node->left!=NULL) q.push(node->left);
		if(node->right!=NULL) q.push(node->right);
	}
}
int Node::height(Node* root){
	int leftHeight=height(root->left);
	int rightHeight=height(root->right);

	return (leftHeight>rightHeight)?leftHeight+1:rightHeight+1;
}
void Node::leftView(Node* root){
	if(root==NULL)
		return;
	queue<Node*> q;
	q.push(root);
	Node* node;
	while(!q.empty()){
		int i=0;
		int size=q.size();
		while(i++<size){
			node=q.front();
			q.pop();
			if(i==1)
				cout<<node->data<<" ";
			if(node->left!=NULL) q.push(node->left);
			if(node->right!=NULL) q.push(node->right);
		}
	}
}
void Node::rightView(Node* root){
	if(root==NULL)
		return;
	queue<Node*> q;
	q.push(root);
	Node* node;
	while(!q.empty()){
		int i=0;
		int size=q.size();
		while(i++<size){
			node=q.front();
			q.pop();
			if(i==size)
				cout<<node->data<<" ";
			if(node->left!=NULL) q.push(node->left);
			if(node->right!=NULL) q.push(node->right);
		}
}
int main(){
	Node* root=new Node(12);
	root->levelOrder(root);
	return 0;
}