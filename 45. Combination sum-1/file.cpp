#include<stdio.h>
#include<bits/stdc++.h>
#include<algorithm>
#include<vector>
using namespace std; 

void solve(vector<vector<int>> &res,vector<int> &r,vector<int> list,int start,int sum,int target){
	if(sum>target)
		return;
	if(sum==target){
		res.push_back(r);
		return;
	}
	for(int i=start;i<list.size();i++){
		r.push_back(list[i]);
		solve(res,r,list,i,sum+list[i],target);

		r.pop_back();
	}
}
void printtList(vector<int> list){
	for(int i=0;i<list.size();i++)
		printf("%d ",list[i]);
}
void printtList(vector<vector<int>> list){
	for(int i=0;i<list.size();i++){
		for(int j=0;j<list[i].size();j++)
			printf("%d ",list[i][j]);
		printf("\n");
	}
}
void format(vector<int> list){
	sort(list.begin(),list.end());
	//auto it=unique(list.begin(),list.begin()+list.size());
	//list.resize(distance(list.begin(),it));
	//printtList(list);
}
int main(){
	vector<int> list={2,4,6,8};
	format(list);

	vector<vector<int>> res;
	vector<int> r;
	int target=8;
	solve(res,r,list,0,0,target);

	printtList(res);
	return 0;
}