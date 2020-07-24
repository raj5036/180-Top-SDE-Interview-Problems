#include<iostream>
#include<bits/stdc++.h>
#include<Stack>

using namespace std;

bool isMatching(char a,char b){
	return (a=='['&&b==']') || (a=='{'&&b=='}') || (a=='('&&b==')');
}
bool isValid(char braces[],int n){
	stack<char> s;

	for(int i=0;i<n;i++){
		if(braces[i]=='['||braces[i]=='{'||braces[i]=='(')
			s.push(braces[i]);
		else{
			if(s.empty()){
				return false;
			}else if(isMatching(s.top(),braces[i]) ){
				s.pop();
			}else if(!isMatching(s.top(),braces[i]))
				return false;				
		}
	}
	if(!s.empty())
		return false;
	return true;
}
int main(){
	char braces[]={'[','(',')',']','('};
	int n=sizeof(braces)/sizeof(braces[0]);
	if(isValid(braces,n))
		cout<<"YES"<<endl;
	else
		cout<<"NO"<<endl;
	return 0;
}