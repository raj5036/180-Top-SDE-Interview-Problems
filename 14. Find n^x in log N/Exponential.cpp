#include<iostream>
using namespace std;
int exponent(int x,int y){
	if(y==0)
		return 1;
	if(y==1)
		return x;
	int temp=exponent(x,y/2);
	if(y%2==0)
		return temp*temp;
	else
		return x*temp*temp;
}
int main(){
	int x,y;
	cin>>x>>y;
	int ans=exponent(x,y);
	cout<<ans;
	return 0;
}