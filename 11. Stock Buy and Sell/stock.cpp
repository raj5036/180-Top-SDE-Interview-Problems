#include <iostream>
#include<bits/stdc++.h>
using namespace std;

void func(int *a,int n){
    int i = 0; 
    while (i < n - 1) { 
  
        // Find Local Minima 
        // Note that the limit is (n-2) as we are 
        // comparing present element to the next element 
        while ((i < n - 1) && (price[i + 1] <= price[i])) 
            i++; 
  
        // If we reached the end, break 
        // as no further solution possible 
        if (i == n - 1) 
            break; 
  
        // Store the index of minima 
        int buy = i++; 
  
        // Find Local Maxima 
        // Note that the limit is (n-1) as we are 
        // comparing to previous element 
        while ((i < n) && (price[i] >= price[i - 1])) 
            i++; 
  
        // Store the index of maxima 
        int sell = i - 1; 
  
        cout << "Buy on day: " << buy 
             << "\t Sell on day: " << sell << endl; 
    } 
}
bool noProfit(int *a ,int n){
    for(int i=0;i<n-1;i++)
        if(a[i]<a[i+1])
            return false;
    return true;
}
int main() {
	int t;
	cin>>t;
	while(t--){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++)
	        cin>>a[i];
        if(noProfit(a,n))
            std::cout<<"No Profit"<<endl;
        else
            func(a,n);
	}
	return 0;
}