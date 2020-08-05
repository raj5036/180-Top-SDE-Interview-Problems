#include<iostream>
#include<bits/stdc++.h>
using namespace std; 

#define R 3
#define C 3

void rotateMatrix(int R,int C,int[][] a){
	int row,col,m,n;
	int prev,cur;
	while(row<m && col<n){
		int prev=a[row+1][col];
		for(int i=col;i<n;i++){
			cur=a[row][i];
			a[row][i]=prev;
			prev=cur;
		}
		row++;

		for(int i=row;i<m;i++){
			cur=a[i][n-1];
			a[i][n-1]=prev;
			prev=cur;
		}
		n--;

		if(row<m){
			for(int i=n-1;i>=col;i--){
				cur=a[m-1][i];
				a[m-1][i]=prev;
				prev=cur;
			}
		}
		m--;
		if(col<n){
			for(int i=m-1;i>=row;i--){
				cur=a[i][col];
				a[i][col]=prev;
				prev=cur;
			}
		}
		col++;
	}
}
int main(){
	int a[][]={
		{1,2,3},
		{4,5,6},
		{7,8,9}
	}
	rotateMatrix(R,C,a);
}