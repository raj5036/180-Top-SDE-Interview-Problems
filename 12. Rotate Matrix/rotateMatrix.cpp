#include<iostream>
#include<bits/stdc++.h>
using namespace std; 

#define R 3
#define C 3

void rotateMatrix(int a[R][C]){
	int row=0,col=0,m=R,n=C;     //Value of m & n
	int prev,cur;
	while(row<m and col<n){
		if(row+1==m or col+1==n) break;

		prev=a[row+1][col];
		for(int i=col;i<n;i++){
			cur=a[row][i];
			a[row][i]=prev;
			prev=cur;
		}
		row++;

		for(int i=row;i<m;i++){
			cur=a[i][n-1];     //Last column specific
			a[i][n-1]=prev;
			prev=cur;
		}
		n--;

		if(row<m)
			for(int i=n-1;i>=col;i--){
				cur=a[m-1][i];        //Last row specific
				a[m-1][i]=prev;
				prev=cur;
			}
		m--;
		
		if(col<n)
			for(int i=m-1;i>=row;i--){
				cur=a[i][col];
				a[i][col]=prev;
				prev=cur;
			}
		col++;
		
	}
}
void printMatrix(int a[R][C]){
	for(int i=0;i<R;i++){
		for(int j=0;j<C;j++)
			std::cout<<a[i][j]<<" ";
		std::cout<<endl;
	}
}
int main(){
	int a[R][C]={
		{1,2,3},
		{4,5,6},
		{7,8,9}
	};
	rotateMatrix(a);
	printMatrix(a);
	return 0;
}