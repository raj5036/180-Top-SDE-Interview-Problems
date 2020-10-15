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
int lis( int arr[], int n )  
{  
    int lis[n]; 
   
    lis[0] = 1;    
  
    /* Compute optimized LIS values in  
       bottom up manner */
    for (int i = 1; i < n; i++ )  
    { 
        lis[i] = 1; 
        for (int j = 0; j < i; j++ )   
            if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)  
                lis[i] = lis[j] + 1;  
    } 
  
    // Return maximum value in lis[] 
    return *max_element(lis, lis+n); 
}  
int main(){
	int a[]={5 ,8, 3, 7, 9, 1};
	int n=sizeof(a)/sizeof(a[0]);
	int prev=INT_MIN,i=0;
	int length=lis(a,n);
	std::cout<<length<<endl;
	return 0;
}
