import java.util.*;
class Solution{
	permute(int[] a,int l,int r,List<Integer> list){
		if(l==r){
			list.add(a);
		}
		for(int i=l;i<=r;i++){
			swap(a[l],a[r]);
			permute(a,l+1,r);
			swap(a[l],a[r]);
		}
	}
	public static void main(String[] args){
		int n=3,k=4;
		int[] num=new int[n];
		for(int i=0;i<n;i++)
			num[i]=i+1;
 		permute(num,0,num.length-1);
	}
}