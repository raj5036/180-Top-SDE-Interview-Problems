import java.util.*;
import java.util.stream.*;
class Solution{ //This solution does not exclude duplicates
	int removeDuplicates(int[] a){
		int n=a.length;
		if(n==0 || n==1)
			return n;
		int j=0;
		for(int i=0;i<n-1;i++)
			if(a[i]!=a[i+1])
				a[j++]=a[i];
		a[j++]=a[n-1];
		return j;
	}
	int format(int[] a){
		Arrays.sort(a);
		int n=removeDuplicates(a);
		return n;
	}
	void combinationalSum(int[] a,int n,List<Integer> r,List<List<Integer>> res,int start,int target,int sum){
		if(sum>target)
			return;
		if(sum==target){
			res.add(new ArrayList<>(r));
			return;
		}
		for(int i=start;i<n;i++){
			r.add(a[i]);
			combinationalSum(a,n,r,res,i,target,sum+a[i]);
			r.remove(r.size()-1);
		}
	}
	public static void main(String[] args){
		Solution obj=new Solution();
		int[] a={2,4,6,8};
		int target=8;
		int n=obj.format(a);
		System.out.println(n);
		List<Integer> r=new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		obj.combinationalSum(a,n,r,res,0,target,0);

		//remove duplicates from the output
		List<List<Integer>> ans = new ArrayList<>();
		for(List<Integer> list:res)
			if(!ans.contains(list))
				ans.add(list);
		System.out.println(res);
	}
}