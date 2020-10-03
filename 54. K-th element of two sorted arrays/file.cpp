#include<bits/stdc++.h>
using namespace std; 

void merge(int *a1,int *a2,int m,int n){
	for(int i=n-1;i>=0;i--){
		int last=a1[m-1],j;
		for(j=m-2;j>=0 && a1[j]>a2[i];j--)
			a1[j+1]=a1[j];

		if(j!=m-2 || last>a2[i]){
			a1[j+1]=a2[i];
			a2[i]=last;
		}
	}
	
}
void printList(int *a,int n){
	for(int i=0;i<n;i++)
		cout<<a[i]<<" ";
	cout<<endl;
}
int main(){
	int a1[100],a2[100];
	int m,n,k;
	cin>>m>>n>>k;
	for(int i=0;i<m;i++)
		cin>>a1[i];
	for(int i=0;i<n;i++)
		cin>>a2[i];
	merge(a1,a2,m,n);
	printList(a1,m);
	printList(a2,n);
	if(k<=m)
		cout<<a1[k-1];
	else
		cout<<a2[k-m-1];
	return 0;
}