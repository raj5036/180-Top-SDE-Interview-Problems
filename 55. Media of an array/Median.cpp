#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int partition(int *a,int low,int high){
	int pivot=a[high];
	int i=low-1;
	for(int j=low;j<=high-1;j++)
		if(a[j]<=pivot){
			i++;
			swap(a[i],a[j]);
		}

	swap(a[i+1],a[high]);
	return i+1;
}
void quickSort(int *a,int low,int high){
	if(low<high){
		int pi=partition(a,low,high);
		quickSort(a,low,pi-1);
		quickSort(a,pi+1,high);
	}
}
void printArray(int *a,int n){
	for(int i=0;i<n;i++)
		std::cout<<a[i]<<" "<<endl;
}
double findMean(int *a,int n){
	int sum=0;
	for(int i=0;i<n;i++)
		sum+=a[i];
	return (double)sum/(double)n;
}
double findMedia(int *a,int n){
	quickSort(a,0,n-1);
	printArray(a,n);
	if(n%2!=0)
		return (double)a[n/2];
	return (double)(a[(n-1)/2]+a[n/2])/2.0;
}
int main(){
	int a[]={1, 3, 4, 2, 7, 5, 8, 6};
	int n=sizeof(a)/sizeof(a[0]);
	std::cout<<findMean(a,n)<<endl;
	std::cout<<findMedia(a,n)<<endl;
	return 0;
}