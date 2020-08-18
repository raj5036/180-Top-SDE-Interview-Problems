#include<iostream>
#include<bits/stdc++.h>
using namespace std;

void update(vector<vector<int>> &matrix,int row,int col){
        for(int i=0;i<matrix.size();i++)
            if(matrix[row][i]!=0)
                matrix[row][i]=-10000;
        for(int i=0;i<matrix[row].size();i++)
            if(matrix[i][col]!=0)
                matrix[i][col]=-10000;
    }
void setZeroes(vector<vector<int>>& matrix) {
    for(int i=0;i<matrix.size();i++)
        for(int j=0;j<matrix[i].size();j++)
            if(matrix[i][j]==0)
                update(matrix,i,j);
    
    for(int i=0;i<matrix.size();i++)
        for(int j=0;j<matrix[i].size();j++)
            if(matrix[i][j]==-10000)
                matrix[i][j]=0;
}
void printMatrix(vector<vector<int>> &matrix){
	for(int i=0;i<matrix.size();i++){
		for(int j=0;j<matrix[i].size();j++)
			std::cout<<matrix[i][j]<<" ";
		std::cout<<endl;
	}
}
int main(){
	vector<vector<int>> matrix={
		{0,1,2,0},
		{3,4,5,2},
		{1,3,1,5}
	};
	setZeroes(matrix);
	printMatrix(matrix);
	return 0;
}