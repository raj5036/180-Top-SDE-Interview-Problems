/*Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j*/
import java.util.*;
import java.util.stream.*;
public class CountInversions{
	final static int size=100;
	static int count=0;
	/*Approach 1*/ //Brute-Force //Time complexity : O(n^2)
	static int inversions(int[] a){
		int n=a.length,count=0;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(a[i]>a[j])
					count++;
		return count;
	}
	/*Approach 2*/ //Using Merge Sort //Time complexity : O(nlogn)
	
	public static void main(String[] args){
		int[] a={8, 4, 2, 1};
		System.out.println(inversions(a));
		int[] aux=Arrays.copyOf(a,a.length);
		mergeSort(a,aux,0,a.length-1);
		System.out.println(Arrays.toString(a));
		System.out.println(count);
	}
}