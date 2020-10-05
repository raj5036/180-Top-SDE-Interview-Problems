<<<<<<< HEAD
#include<bits/stdc++.h>
#include<unordered_map>
using namespace std;
vector<int> twoSum(vector<int>& nums,int target){
		unordered_map <int, int> m;
        for (int i{0}; i<nums.size(); i++){
            if (m.find(target-nums[i]) != m.end())
                return { m[target-nums[i]] , i };
            m[nums[i]] = i;
        }
         return {};
}
int main(){
	vector<int> nums={2, 7, 11, 15};
	int target=9;
	vector<int> ans=twoSum(nums,target);
	sort(ans.begin(),ans.end());
	for(int i=0;i<ans.size();i++)
		std::cout<<ans[i]<<endl;
	return 0;
=======
#include<bits/stdc++.h>
#include<unordered_map>
using namespace std;
vector<int> twoSum(vector<int>& nums,int target){
	unordered_map <int, int> m;
        for (int i{0}; i<nums.size(); i++){
            if (m.find(target-nums[i]) != m.end())
                return { m[target-nums[i]] , i };
            m[nums[i]] = i;
        }
         return {};
}
int main(){
	vector<int> nums={2, 7, 11, 15};
	int target=9;
	vector<int> ans=twoSum(nums,target);
	sort(ans.begin(),ans.end());
	for(int i=0;i<ans.size();i++)
		std::cout<<ans[i]<<endl;
	return 0;
>>>>>>> a0e259894785f341e7bf34e7f7c4143b02f2eb3a
}