import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class MaxProductSubarray{
	static int max_product_subarray(int[] a,int n){ //doesn't pass all the testcases
		int max_so_far=1,max_ending_here=1,min_ending_here=1,flag=0;
		for(int i=0;i<n;i++){
			if(a[i]>0){
				max_ending_here=max_ending_here*a[i];
				min_ending_here=Math.min(min_ending_here*a[i],1);
				flag=1;
			}else if(a[i]==0){
				max_ending_here=1;
				min_ending_here=1;
			}else{
				int temp=max_ending_here;
				max_ending_here=Math.max(min_ending_here*a[i],1);
				min_ending_here=temp*a[i];
			}
			 if (max_so_far<max_ending_here) 
                max_so_far = max_ending_here; 
		}
		if(flag==0 && max_so_far==1)
			return 0;
		return max_so_far;
	}
	public static int maxProduct(int[] a){ //Pass all testcases
		if(a.length==1)
			return a[0];
		// maintain two variables to store maximum and minimum product
		// ending at current index
		int max_ending = 0, min_ending = 0;

		// to store maximum product sub-array found so far
		int max_so_far = 0;

		// traverse the given array
		for (int i: A)
		{
			int temp = max_ending;

			// update maximum product ending at current index
			max_ending = Integer.max(i, Integer.max(i * max_ending,
													i * min_ending)
									);

			// update minimum product ending at current index
			min_ending = Integer.min(i, Integer.min(i * temp, i * min_ending));

			max_so_far = Integer.max(max_so_far, max_ending);
		}

		// return maximum product
		return max_so_far;
	}
	public static void main(String[] args){
		int[] a={1, -2, -3, 0, 7, -8, -2};
		System.out.println(Arrays.stream(a).max().getAsInt());
		System.out.println(max_product_subarray(a,a.length));
	}
}