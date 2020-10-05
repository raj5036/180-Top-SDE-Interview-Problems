#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main(){
 	int s[] =  {10, 12, 20}; 
	int f[] =  {20, 25, 30}; 
	int n=sizeof(s)/sizeof(s[0]);
	int maxSoFar=INT_MIN;
	for(int i=0;i<n;i++)
		if(s[i]>=maxSoFar){
			std::cout<<i<<" ";
			maxSoFar=f[i];
		}
	return 0;
}