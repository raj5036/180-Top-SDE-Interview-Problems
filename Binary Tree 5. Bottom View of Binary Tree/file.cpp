#include<bits/stdc++.h>
#include<algorithm>
#include<queue>
#include<map>
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
void BottomView(Node* root){
	struct QueueObj{
		int hd;
		Node* node;
		QueueObj(Node* node,int hd){
			this->hd=hd;
			this->node=node;
		}
	};
	queue<QueueObj*> q;
	map<int,Node*> map;
	q.push(new QueueObj(root,0));
	map.insert(pair<int,Node*>(0,root));
	while(!q.empty()){
		QueueObj* temp=q.front();
		q.pop();
		map.insert(pair<int,Node*>(temp->hd,temp->node));
		if(temp->node->left)
			q.push(new QueueObj(temp->node->left,temp->hd - 1));
		if(temp->node->right)
			q.push(new QueueObj(temp->node->right,temp->hd + 1));
	}

	for(auto i=map.begin();i!=map.end();i++)
		cout<<i->second->data<<" ";
} 
int main(){
	Node* root = new Node(20); 
	root->left = new Node(8); 
	root->right = new Node(22); 
	root->left->left = new Node(5); 
	root->left->right = new Node(3); 
	root->right->left = new Node(4); 
	root->right->right = new Node(25); 
	root->left->right->left = new Node(10); 
	root->left->right->right = new Node(14); 

	BottomView(root);
	return 0;
}