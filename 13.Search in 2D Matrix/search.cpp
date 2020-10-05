#include<bits/stdc++.h>
#include<vector>
using namespace std;

bool binarySearch(vector<int>& a,int K){
	int low=0,high=a.size()-1;
	while(low<=high){
		int mid=low+(high-low)/2;
		if(a[mid]==K)
			return true;
		if(a[mid]<K)
			low=mid+1;
		else
			high=mid-1;
	}
	return false;
}
bool search(vector<vector<int>>& matrix,int K){
	int n=matrix.size(),m=matrix[0].size();
	int low=0,high=n-1;
	while(low<=high){
		int mid=low+(high-low)/2;
		if(K>=matrix[mid][0] && K<=matrix[mid][m-1])
			return binarySearch(matrix[mid],K);
		if(K<matrix[mid][0])
			high=mid-1;
		else if(K>matrix[mid][m-1])
			low=mid+1;
	}
	return false;
}
int main(){
	vector<vector<int>> matrix={
				{ 1, 3, 5, 7 }, 
             	{ 10, 11, 16, 20 }, 
             	{ 23, 30, 34, 50 }
			};
	int K=17;
	if(search(matrix,K)==true)
		cout<<"true"<<endl;
	else
		cout<<"false"<<endl;
	return 0;
}
