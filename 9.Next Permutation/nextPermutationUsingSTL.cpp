#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
using namespace std;

int main(){
	string s="gfg";
	bool val=next_permutation(s.begin(),s.end());
	if(!val)
		std::cout<<"No such word is possible"<<endl;
	else
		std::cout<<s<<endl;
	return 0;
}