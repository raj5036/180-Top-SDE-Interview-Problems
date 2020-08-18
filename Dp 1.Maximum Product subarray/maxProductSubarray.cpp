#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
using namespace std;
int max_product_subarray(int *a,int n){
	int max_ending_here=1,min_ending_here=1,max_so_far=1,flag=0;
	for(int i=0;i<n;i++){
		if(a[i]>0){
			max_ending_here=max_ending_here*a[i];
			min_ending_here=std::min(min_ending_here*a[i],1);
			flag=1;
		}
		else if(a[i]==0){
			max_ending_here=1;
			min_ending_here=1;
		}
		else{
			/* If element is negative. This is tricky   
		        max_ending_here can either be 1 or positive.   
		        min_ending_here can either be 1 or negative.   
		        next max_ending_here will always be prev.   
		        min_ending_here * arr[i] ,next min_ending_here   
		        will be 1 if prev max_ending_here is 1, otherwise   
		        next min_ending_here will be prev max_ending_here *   
		        arr[i] 
	        */
			int temp=max_ending_here;
			max_ending_here=std::max(min_ending_here*a[i],1);
			min_ending_here=temp*a[i];
		}
		max_so_far=std::max(max_ending_here,max_so_far);
	}
	if(flag==0 && max_so_far==1)
		return 0;
	return max_so_far;
}
int main(){
	int a[]={1, -2, -3, 0, 7, -8, -2};
	int n=sizeof(a)/sizeof(a[0]);
	int ans=max_product_subarray(a,n);
	std::cout<<ans<<endl;
	return 0;
}