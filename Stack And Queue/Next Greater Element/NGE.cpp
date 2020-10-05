#include <iostream>
#include<bits/stdc++.h>
#include<stack>
using namespace std;

void NGE(int a[],int n){
    for(int i=0;i<n;i++)
        for(int j=i+1;j<n;j++)
            if(a[j]>a[i]){
                cout<<a[j]<<" ";
                break;
            }else if(j==n-1){
                cout<<-1<<" ";
            }
}
void printNGE(int a[], int n) { 
  stack < int > s; 
  
  /* push the first element to stack */
  s.push(a[0]); 
  
  // iterate for rest of the elements 
  for (int i = 1; i < n; i++) { 
  
    if (s.empty()) { 
      s.push(a[i]); 
      continue; 
    } 
  
    /* if stack is not empty, then 
       pop an element from stack. 
       If the popped element is smaller 
       than next, then 
    a) print the pair 
    b) keep popping while elements are 
    smaller and stack is not empty */
    while (s.empty() == false && s.top() < a[i]) 
    {          
        cout << s.top() << " --> " << a[i] << endl; 
        s.pop(); 
    } 
  
    /* push next to stack so that we can find 
    next greater for it */
    s.push(a[i]); 
  } 
  
  /* After iterating over the loop, the remaining 
  elements in stack do not have the next greater 
  element, so print -1 for them */
  while (s.empty() == false) { 
    cout << s.top() << " --> " << -1 << endl; 
    s.pop(); 
  } 
} 
int main() {
	int t;
	cin>>t;
	while(t-->0){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++)
	        cin>>a[i];
        NGE(a,n);
        cout<<-1;
	}
	return 0;
}