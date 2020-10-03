#include<bits/stdc++.h>
#include<algorithm>
#include<queue>
using namespace std;
struct Node{
	int data;
	Node *left,*right,*next;
	Node(int data){
		this->data=data;
		this->left=this->right=this->next=NULL;
	}
};
Node* insertNode(Node* root,int data){
	if(root==NULL) return new Node(data);
	else if(data<root->data)
		root->left=insertNode(root->left,data);
	else if(data>root->data)
		root->right=insertNode(root->right,data);
	return root;
}
void inOrder(Node* root){
	if(root!=NULL){
		inOrder(root->left);
		cout<<root->data<<" ";
		inOrder(root->right);
	}
}
void populateNextPointer(Node* root){
	if(root==NULL) return;
	queue<Node*> q;
	q.push(root);
	q.push(NULL);
	
	while(q.front()!=NULL){
		int size=q.size()-1;
		while(size--){
		Node* node=q.front();
		q.pop();
		node->next=q.front();
		if(node->left)
			q.push(node->left);
		if(node->right)
			q.push(node->right);
		}
		q.pop();
		q.push(NULL);
	}
}
int main(){
	Node* root=new Node(31);
	for(int i=0;i<10;i++){
		int data=rand();
		insertNode(root,data);
	}
	populateNextPointer(root);
	inOrder(root);
	return 0;
}