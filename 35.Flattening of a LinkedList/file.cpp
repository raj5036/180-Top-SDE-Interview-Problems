#include<stdio.h>
#include<bits/stdc++.h>
using namespace std;

struct Node{
	int data;
	struct Node* next;
	struct Node* down;
};
void insertNode(struct Node* head,int data){
	struct Node* newNode;
	newNode->data=data;
	if(head==NULL)
		head=newNode;
	else{
		struct Node* cur=head;
		while(cur->next!=NULL)
			cur=cur->next;
	}
}
int main(){
	struct Node* head;

	return 0;
}