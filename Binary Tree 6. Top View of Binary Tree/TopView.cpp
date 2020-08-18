#include<stdio.h>
#include<stdlib.h>
#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
#include<queue>
#include<map>
#include<iterator>
struct Node{
	int data;
	struct Node* left;
	struct Node* right;

	Node(int x){
		data=x;
		left=right=NULL;
	}
};
Node* addNode(Node* root,int data){
	if(root==NULL) return new Node(data);
	if(data<root->data)
		root->left=addNode(root->left,data);
	else if(data>root->data)
		root->right=addNode(root->right,data);
	return root;
}
void inOrder(Node* root){
	if(root!=NULL){
		inOrder(root->left);
		printf("%d ",root->data);
		inOrder(root->right);
	}
}
struct QueueObj{
    struct Node* node;
    int hd;
    
    QueueObj(Node* node,int hd){
        this->node=node;
        this->hd=hd;
    }
};
void topView(struct Node *root)
{
    map<int,Node*> hdRecord;
    queue<QueueObj*> q;
    QueueObj* rootObj;
    rootObj->node=root;
    rootObj->hd=0;
    q.push(rootObj);
    int hd=0;
    while(!q.empty()){
        QueueObj* nodeObj=q.front();
        q.pop();
        if(hdRecord.find(nodeObj->hd)==hdRecord.end())
            hdRecord.insert(pair<int,Node*>(nodeObj->hd,nodeObj->node));
        if(nodeObj->node->left!=NULL)
            q.push(new QueueObj(nodeObj->node->left,(nodeObj->hd)-1));
        if(nodeObj->node->right!=NULL)
            q.push(new QueueObj(nodeObj->node->right,(nodeObj->hd)+1));
    }
    
    map<int,Node*>::iterator it;
    for(it=hdRecord.begin();it!=hdRecord.end();it++)
        printf("%d ",it->second->data);
}
int main(){
	Node* root=new Node(45);
	for(int i=0;i<10;i++)
		addNode(root,rand());
	inOrder(root);
	return 0;
}
