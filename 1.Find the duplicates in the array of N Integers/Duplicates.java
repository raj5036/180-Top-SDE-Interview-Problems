import java.util.*;
public class Duplicates{
	/*Approach 1*/
	static void duplicates(int[] a){
		int n=a.length;
		for(int i=0;i<n;i++){
			if(a[Math.abs(a[i])]>0)
				a[Math.abs(a[i])]=-a[Math.abs(a[i])];
			else
				System.out.print(Math.abs(a[i])+" ");
		}
	}
	/*Approach 2*/
	static void duplicates1(int[] a){
		int n=a.length;
		for(int i=0;i<n;i++)
			a[a[i]%n]=a[a[i]%n]+n;
		
		for(int i=0;i<n;i++)
			if(a[i]>n*2)
				System.out.print(i+" ");
	}
	public static void main(String[] args){
		int[] a={1,2,7,4,1,5,3,2,4};
		duplicates1(a);
	}
}