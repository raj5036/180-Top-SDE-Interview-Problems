#include<bits/stdc++.h>
using namespace std;
void detectLoop(struct Node* head){
	struct Node* slow=head;
	struct Node* fast=head;
	while(slow && fast && fast->next!=NULL){
		slow=slow->next;
		fast=fast->next->next;

		if(slow==fast){
			cout<<"Loop Detected"<<endl;
			remove(head,slow);
			break;
		}
	}
}
void remove(struct Node* head,struct Node* loopNode){
	struct Node* ptr1;
	struct Node* ptr2;
	ptr1=head;
	while(true){
		ptr2=loopNode;

		while(ptr2->next!=ptr1 && ptr2->next!=loopNode)
			ptr2=ptr2->next;
		if(ptr2->next==ptr1)
			break;
		ptr1=ptr1->next;
	}
	ptr2->next=NULL; //Loop removed
}