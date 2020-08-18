#include<bits/stdc++.h>
using namespace std;
int minPartitioning(string s){
	int n=s.length();
	bool p[n][n];
	int c[n][n];

	for(int i=0;i<n;i++){
		p[i][i]=true;
		c[i][i]=0;
	}

	for(int L=2;L<=n;L++){ 
		for(int i=0;i<n-L+1;i++){
			int j=i+L-1;
			if(L==2)
				p[i][j]=(s[i]==s[j]);
			else
				p[i][j]=(s[i]==s[j]) && (p[i+1][j-1]);

			if(p[i][j]==true)
				c[i][j]=0;
			else{
				c[i][j]=INT_MAX;
				for(int k=i;k<=j-1;k++)
					c[i][j]=std::min(c[i][j],c[i][k]+c[k+1][j]+1);
			}
		}
	}
	return c[0][n-1];
}
int main(){
	string s="ababbbabbababa";
	std::cout<<minPartitioning(s);
	return 0;
}