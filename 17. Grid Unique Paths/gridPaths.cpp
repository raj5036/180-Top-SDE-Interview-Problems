#include<bits/stdc++.h>
using namespace std;
int gridPathsDP(int a,int b){
	int dp[a+1][b+1];
	for(int i=1;i<=a;i++)
		for(int j=1;j<=b;j++)
			if(i==1 || j==1)
				dp[i][j]=1;
			else
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
	return abs(dp[a][b]);
}
int gridPaths(int a,int b){
	/* If either 1 row or 1 column are there then the only way to end
	         is to traverse through that row or column respectively.*/
	if(a==1 || b==1)
		return 1;
	/*If there are more than one row and column then u need to move 
	        either right or down reducing one row or one column respectively
	        and adding that way in answer*/
	else
		return gridPaths(a-1,b)+gridPaths(a,b-1);
} 
int main(){
	int a,b;
	cin>>a>>b;
	int ans=gridPathsDP(a,b);
	cout<<ans;
}