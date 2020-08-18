import java.util.*;
import java.util.stream.*;
public class Kadene{
	static int maximumSumSubarray(int[] a){
		int curSum=0,maxSum=Integer.MIN_VALUE;
		int n=a.length;
		for(int i=0;i<n;i++){
			curSum+=a[i];
			if(curSum>maxSum)
				maxSum=curSum;
			if(curSum<0)
				curSum=0;
		}
		return maxSum;
	}
	/*Approach2*/
	static int maximumSumSubArray(int[] a){
		int max=Arrays.stream(a).max().getAsInt();//Get the maximum value of the array
		if(max<0)
			return max;
		int maxSoFar=0,curSum=0;
		int maxAtEnding=Integer.MIN_VALUE;
		int n=a.length;
		for(int num:a){
			maxSoFar+=num;
			maxSoFar=Integer.max(maxSoFar,0);
			maxAtEnding=Integer.max(maxAtEnding,maxSoFar);
		}
		return maxAtEnding;
	}
	public static void main(String[] args){
		int[] a={-2,3,1,4,-6,12,43};
		System.out.println(maximumSumSubarray(a));
		System.out.println(maximumSumSubArray(a));
	}
}