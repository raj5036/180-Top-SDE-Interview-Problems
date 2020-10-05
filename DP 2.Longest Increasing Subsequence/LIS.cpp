#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
using namespace std;
int LIS(int *a,int i,int n,int prev){
	if(i==n)
		return 0;
	int exclusion=LIS(a,i+1,n,prev);
	int inclusion=0;
	if(a[i]>prev)
		inclusion=LIS(a,i+1,n,a[i])+1;
	return std::max(inclusion,exclusion);
}
int LISDP(int *a,int n){
	int L[n];
	L[0]=1;
	for(int i=1;i<n;i++){
		for(int j=0;j<i;j++)
			if(a[j]<a[i] && L[j]>L[i])
				L[i]=L[j];
		L[i++];
	}
	auto it=*max_element(a.begin(),a.end());
	
	return it;
}
int main(){
	int a[]={5 ,8, 3, 7, 9, 1};
	int n=sizeof(a)/sizeof(a[0]);
	int prev=INT_MIN,i=0;
	int length=LISDP(a,n);
	std::cout<<length<<endl;
	return 0;
=======
#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
using namespace std;
int LIS(int *a,int i,int n,int prev){
	if(i==n)
		return 0;
	int exclusion=LIS(a,i+1,n,prev);
	int inclusion=0;
	if(a[i]>prev)
		inclusion=LIS(a,i+1,n,a[i])+1;
	return std::max(inclusion,exclusion);
}
int LISDP(int *a,int n){
	int L[n];
	L[0]=1;
	for(int i=1;i<n;i++){
		for(int j=0;j<i;j++)
			if(a[j]<a[i] && L[j]>L[i])
				L[i]=L[j];
		L[i++];
	}
	int max=INT_MIN;
	for(int i=0;i<n;i++)
		if(L[i]>max)
			max=L[i];
	return max;
}
int main(){
	int a[]={5 ,8, 3, 7, 9, 1};
	int n=sizeof(a)/sizeof(a[0]);
	int prev=INT_MIN,i=0;
	int length=LISDP(a,n);
	std::cout<<length<<endl;
	return 0;
>>>>>>> a0e259894785f341e7bf34e7f7c4143b02f2eb3a
}