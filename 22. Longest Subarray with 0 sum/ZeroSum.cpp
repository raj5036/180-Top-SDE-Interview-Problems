#include<bits/stdc++.h>
using namespace std;
int longestSubarray(int a[],int n){
	unordered_map<int,int> umap;
    	int sum=0,maxLength=0;
    	for(int i=0;i<n;i++){
		if(a[i]==0 and maxLength==0)
	    		maxLength+=1;
		sum+=a[i];
		if(sum==0)
	    		maxLength=i+1;
		if(umap.find(sum)==umap.end())
	    		umap[sum]=i;
		else
	    		maxLength=std::max(maxLength,i-umap[sum]);
	}
	return maxLength;
}
int main(){

	return 0;
}