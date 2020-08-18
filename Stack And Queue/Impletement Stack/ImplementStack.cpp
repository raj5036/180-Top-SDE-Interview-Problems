#include<iostream>
#include<bits/stdc++.h>
#define MAX 1000 
using namespace std;
class Stack{
	int top;
	public:
		int a[MAX];
		Stack(){
			top=-1;
		}
		bool push(int n);
		int pop();
		bool empty();
		int getTop();
};
bool Stack::push(int n){
	if(top>=MAX){
		cout<<"Stack overflow "<<endl;
		return false;
	}
	a[++top]=n;
	cout<<n<<" is pushed onto Stack"<<endl;
	return true;
}
int Stack::pop(){
	if(top<=-1){
		cout<<"Stack Underflow ";
		return -1;
	}
	int n=a[top];
	top--;
	return n;
}
bool Stack::empty(){
	return top<=-1;
}
int Stack::getTop(){
	return a[top];
}
int main(){
	class Stack s;
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(214);
	s.push(213);
	return 0;
}