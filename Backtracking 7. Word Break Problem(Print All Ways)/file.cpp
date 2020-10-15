#include<bits/stdc++.h>
#include<string>
#include<iomanip>
using namespace std;

bool dictionaryContains(string word){
	string dictionary[]={
		 "mobile", "samsung", "sam", "sung", "man",
		 "mango", "icecream", "and", "go", "i", "love", "ice", "cream"
	};
	for(string s:dictionary)
		if(s.compare(word)==0)
			return true;
	return false;
}

void wordBreakUtil(string word,int length,string result){
	for(int i=1;i<=length;i++){
		string prefix=word.substr(0,i);
		
		if(dictionaryContains(prefix)){	
			if(i==length){
				result+=prefix;
				cout<<result<<endl;
				return;
			}
			wordBreakUtil(word.substr(i),length-i,result+prefix+" ");
		}
	}
}

void wordBreak(string word){
	wordBreakUtil(word,word.length(),"");
	//cout<<"wordBreak"<<endl;
}

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	
	string word;
	cin>>word;
	wordBreak(word);
	return 0;
}
