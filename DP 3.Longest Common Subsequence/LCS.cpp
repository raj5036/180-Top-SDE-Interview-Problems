#include <iostream>
#include<algorithm>
#include<string>
#include<bits/stdc++.h>
using namespace std;


int LCS(string a,string b,int m,int n){
    if(m==0 || n==0)
        return 0;
    if(a[m-1]==b[n-1])
        return LCS(a,b,m-1,n-1)+1;
    else
        return std::max( LCS(a,b,m-1,n),LCS(a,b,m,n-1) );
}
int LCSDP(string a,string b,int m,int n){
    int memo[m+1][n+1];
    for(int i=1;i<=m;i++)
        for(int j=1;j<=n;j++)
            if(i==0 || j==0)
                memo[i][j]=0;
            else if(a[i]==b[j])
                memo[i][j]=memo[i-1][j-1]+1;
            else
                memo[i][j]=std::max(memo[i-1][j],memo[i][j-1]);
    return memo[m][n];
}

int main() {
    int t;
    cin>>t;
    while(t--){
    	string a,b;
        getline(cin,a);
        cout<<endl;
        //std::cout<<a<<endl;
        getline(cin,b);
        //std::cout<<b<<endl;
        int m=a.length(),n=b.length();
        std::cout<<LCS(a,b,m,n);
    }
	return 0;
}