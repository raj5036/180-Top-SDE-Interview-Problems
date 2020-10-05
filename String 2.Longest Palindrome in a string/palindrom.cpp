#include <iostream>
#include<bits/stdc++.h>
using namespace std;
string expand(string s,int low,int high){
    while(low>=0 && high<s.length()){
        if(s[low]==s[high]){
            low--;
            high++;
        }
    }
    return s.substr(low+1,(high-1)-(low+1));
}
string LPS(string s,int length){
    string cur_str,max_str="";
    int cur_len,max_len=0;
    
    for(int i=0;i<length;i++){
        cur_str=expand(s,i,i); //Odd Palindrome substr;
        cur_len=cur_str.length();
        
        if(cur_len>max_len){
            max_len=cur_len;
            max_str=cur_str;
        }
        
        cur_str=expand(s,i,i+1);//even
        cur_len=cur_str.length();
        
        if(cur_len>max_len){
            max_len=cur_len;
            max_str=cur_str;
        }
    }
    return max_str;
}
int main() {
	
    string s;
    getline(cin,s);
    std::cout<<LPS(s,s.length()-1);
	
	return 0;
}