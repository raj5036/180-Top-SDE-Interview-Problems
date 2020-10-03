#include<stdio.h>
#include<bits/stdc++.h>
#include<unordered_map>
using namespace std;

void solve(int a[],int n){
	unordered_map<int,int> umap;
	int sum=0,maxLen=0;
	for(int i=0;i<n;i++){
		sum+=a[i];
		if(a[i]==0 && maxLen==0)
			maxLen=1;
		if(sum==0)
			maxLen=i+1;
		else{
			if(umap.find(sum)==umap.end())
				umap[sum]=i;
			else
				maxLen=std::max(maxLen,i-umap[sum]);
		}
	}
	printf("%d\n",maxLen);
}
int main(){
	int a[]={1, 2, 3};
	int n=sizeof(a)/sizeof(a[0]);
	solve(a,n);
	return 0;
}