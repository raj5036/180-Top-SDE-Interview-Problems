import java.util.*;
import java.util.stream.*;
public class MergeSortedArrays{
	static int[] Approach1(int[] a,int[] b){
		int m=a.length,n=b.length;
		int size=m+n;
		int[] ans=new int[size];
		int i=0,j=0,index=0;
		while(i<m && j<n){
			if(a[i]<b[j]){
				ans[index]=a[i];
				i++;
			}else{
				ans[index]=b[j];
				j++;
			}
			index++;
		}
		if(i!=m){
			while(i<m){
				ans[index++]=a[i];
				i++;
			}
		}
		if(j!=n){
			while(j<n){
				ans[index++]=b[j];
				j++;
			}
		}
		return ans;
	}
	/*
		Input: ar1[] = {10};
      	ar2[] = {2, 3};
		Output: ar1[] = {2}
		        ar2[] = {3, 10}  

		Input: ar1[] = {1, 5, 9, 10, 15, 20};
		       ar2[] = {2, 3, 8, 13};
		Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20} 
	*/
    static void Approach2(int ar1[], int ar2[], int m, int n){ 
	
		for (int i=n-1; i>=0; i--) 
		{ 
			int j, last = ar1[m-1]; 
			for (j=m-2; j >= 0 && ar1[j] > ar2[i]; j--) 
				ar1[j+1] = ar1[j]; 

			// If there was a greater element 
			if (j != m-2 || last > ar2[i]) 
			{ 
				ar1[j+1] = ar2[i]; 
				ar2[i] = last; 
			} 
		} 
	} 

	public static void main(String[] args){
		int[] a={1, 5, 9, 10, 15, 20};
		int[] b={10, 13, 15, 20};
		
		System.out.println(Arrays.toString(Approach1(a,b)));
		Approach2(a,b,a.length,b.length);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}