#include<stdio.h>
#include<bits/stdc++.h>
using namespace std;

string convertToRoman(int number){
	string ans="";
	int num[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000}; 
    string sym[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"}; 
    int i=12;

    while(number>0){
    	int div=number/num[i];
    	number=number%num[i];

   		while(div--)
   			ans+=sym[i];
   		i--;
    }
    return ans;
}
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		int num;
		scanf("%d",&num);
		cout<<convertToRoman(num)<<endl;
	}
}