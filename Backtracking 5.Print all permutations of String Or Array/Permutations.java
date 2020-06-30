import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class Permutations{
	String swap(String s,int i,int j){
		char[] charArray=s.toCharArray();
		char temp=charArray[i];
		charArray[i]=charArray[j];
		charArray[j]=temp; 
		return String.valueOf(charArray);
	}
	void permute(String s,int l,int r){
		if(l==r)
			System.out.println(s);
		else
			for(int i=l;i<=r;i++){
				s=swap(s,l,i);
				permute(s,l+1,r);
				s=swap(s,l,i);
			}
	}

	int[] swap(int[] a,int l,int r){
		int temp=a[l];
		a[l]=a[r];
		a[r]=temp;
		return a;
	}
	void permute(int[] a,int l,int r){
		if(l==r)
			System.out.println(Arrays.toString(a));
		else
			for(int i=l;i<=r;i++){
				a=swap(a,l,i);
				permute(a,l+1,r);
				a=swap(a,l,i);
			}
	}
	public static void main(String[] args){
		Permutations obj=new Permutations();
		String a="raj";
		obj.permute(a,0,a.length()-1);
		System.out.println();
		int[] array={33,2,123};
		obj.permute(array,0,array.length-1);
	}
}