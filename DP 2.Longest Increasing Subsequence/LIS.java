import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class LIS{
	static int LISLength(int[] a,int i,int n,int prev){ //Time complexity : O(n^2)
		if(i==n)
			return 0;
		int exclusion=LISLength(a,i+1,n,prev);
		int inclusion=0;
		if(a[i]>prev)
			inclusion=LISLength(a,i+1,n,a[i])+1;	
		return Integer.max(exclusion,inclusion);
	}
	static int LISLengthDP(int[] a,int n){
		int[] L=new int[n];
		Arrays.fill(L,0);
		L[0]=1;
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++)
				if(a[j]<a[i] && L[j]>L[i])
					L[i]=L[j];
			L[i]++;
		}
		return Arrays.stream(L).max().getAsInt();
	}
	public static void main(String[] args){
		int[] a={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(LISLength(a,0,a.length,Integer.MIN_VALUE));
		System.out.println(LISLengthDP(a,a.length));
	}
}