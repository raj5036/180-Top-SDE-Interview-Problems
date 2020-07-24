#include<iostream>
#include<bits/stdc++.h>
#include<stack>
using namespace std;

int main(void){
	stack<int> s;
	for(int i=0;i<=10;i++)
		s.push(i);

	cout<<"Stack1 "<<endl;
	cout<<"top "<<s.top()<<endl;
	cout<<"Size "<<s.size()<<endl;
	/*
		while(!s.empty()){
			cout<<s.top()<<" ";
			s.pop();
		}
	*/
	stack<int> test;
	for(int i=11;i<=20;i++)
		test.push(i);
	//std::swap(test); //*****************
	cout<<"Test Stack"<<endl;
	while(!test.empty()){
		cout<<test.top()<<" ";
		test.pop();
	}
	cout<<"Main Stack"<<endl;
	while(!s.empty()){
		cout<<s.top()<<" ";
		s.pop();
	}
}