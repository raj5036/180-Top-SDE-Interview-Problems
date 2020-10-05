import java.util.*;
public class Sort{
	/*Approach 1*/
	static void sort(int[] a){
		int n=a.length;
		int numOfZeroes=0,numOfOnes=0,numOfTwos=0;
		for(int i=0;i<n;i++)
			if(a[i]==0) numOfZeroes++;
			else if(a[i]==1) numOfOnes++;
			else numOfTwos++;
			//System.out.println(numOfZeroes+" "+numOfOnes+" "+numOfTwos);
		for(int i=0;i<n;i++){
			if(numOfZeroes!=0){
				a[i]=0;
				numOfZeroes--;
				continue;
			}
			if(numOfOnes!=0){
				a[i]=1;
				numOfOnes--;
				continue;
			}
			if(numOfTwos!=0){
				a[i]=2;
				numOfTwos--;
			}
		}
	}
	/*Approach 2*/
	static void sort1(int[] a){
		int start=0,end=a.length-1;
		int index=0,n=a.length;
		while(index<=end && start<=end){
			if(a[index]==0){
				a[index]=a[start];
				a[start]=0;
				start++;
				index++;
			}else if(a[index]==2){
				a[index]=a[end];
				a[end]=2;
				end--;
			}else
				index++;
		}
	}
	public static void main(String[] args){
		int[] a={0,2,1,2,1,0,1,0,2,1};
		sort1(a);
		System.out.println(Arrays.toString(a));
	}
}