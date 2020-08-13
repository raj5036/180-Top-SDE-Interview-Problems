#include<bits/stdc++.h>
using namespace std;
int longestSubarray(int a[],int n){
	unordered_map<int,int> umap;
	int maxLength=0;
	for(int i=0;i<n;i++){
		if(a[i]==0 and maxLength==0)
			maxLength=1;
		if(sum==0)
			maxLength=i+1;
		if(umap.find(sum)!=umap.end())
			maxLength=std::max(maxLength,i-umap[sum]);
		else
			umap[sum]=i;
	}
	return maxLength;
}
int main(){

	return 0;
}