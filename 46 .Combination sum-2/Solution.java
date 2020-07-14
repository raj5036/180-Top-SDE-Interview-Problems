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
		int previous=-1;  //*************
		for(int i=start;i<n;i++){
			if(a[i]!=previous){ //each time start from different element
				r.add(a[i]);
				combinationalSum(a,n,r,res,i+1,target,sum+a[i]); //*********** i+1
				r.remove(r.size()-1);
				previous=a[i];
			}	
		}
	}
	public static void main(String[] args){
		Solution obj=new Solution();
		int[] a={10,1,2,7,6,1,5};
		int target=8;
		int n=obj.format(a);
		System.out.println(n);
		List<Integer> r=new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		obj.combinationalSum(a,n,r,res,0,target,0);

		System.out.println(res);
	}
}