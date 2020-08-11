#include<bits/stdc++.h>
#include<list>
#include<unordered_map>
using namespace std;

class LRU{
	int capacity;
	list<int> dq;
	unordered_map<int,list<int>::iterator> umap;

public:
	LRU(int);
	void refer(int);
	void display();
};

LRU::LRU(int n){
	this->capacity=n;
}
void LRU::refer(int x){
	if(umap.find(x)==umap.end()){
		if(dq.size()==capacity){
			int last=dq.back();
			dq.pop_back();
			umap.erase(last);
		}
	}
	else{
		dq.erase(umap[x]);
	}

	dq.push_front(x);
	umap[x]=dq.begin();
}
void LRU::display(){
	for(auto it=dq.begin();it!=dq.end();++it)
		std::cout<<*it<<" ";
}

int main(){
	LRU ca(4); 
  
    ca.refer(1); 
    ca.refer(2); 
    ca.refer(3); 
    ca.refer(1); 
    ca.refer(4); 
    ca.refer(5); 
    ca.display();
	return 0;
}