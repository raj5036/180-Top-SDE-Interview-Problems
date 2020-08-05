#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void merge(int *a1,int *a2,int m,int n){
	for(int i=n-1;i>=0;i--){
		int last=a1[m-1],j;
		for(j=m-2;j>=0 && a1[j]>a2[i];j--){
			a1[j+1]=a1[j];
		}

		if(j!=m-2 && last>a2[i]){
			a1[j+1]=a2[i];
			a2[i]=last;
		}
	}
}
void printArray(int *a,int n){
	for(int i=0;i<n;i++)
		std::cout<<a[i]<<" ";
	std::cout<<endl;
}
int main(){
	int a1[]={2,3,6,7,9};
	int m=sizeof(a1)/sizeof(a1[0]);
	int a2[]={1,4,8,10};
	int n=sizeof(a2)/sizeof(a2[0]);
	int K=5;
	merge(a1,a2,m,n);
	printArray(a1,m);
	printArray(a2,n);
	
	if(K<m)
		std::cout<<a1[K-1];
	else
		std::cout<<a2[(K-m)-1];
	return 0;
}