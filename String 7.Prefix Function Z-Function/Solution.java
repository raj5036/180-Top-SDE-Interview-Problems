import java.util.*;
class Solution{
	int LCP(String a,String b){
		int i=0,j=0;
		while(i<a.length() && j<b.length()){
			if(a.charAt(i)!=b.charAt(j))
				break;
			i++;
			j++;
		}
		return a.substring(0,i).length();
	}
	int[] ZFunction(String s){
		int n=s.length();
		int[] a=new int[n];
		for(int i=1;i<n;i++){
			a[i]=LCP(s,s.substring(i));
		}
		return a;
	}
	public static void main(String[] args){
		Solution obj=new Solution();
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			System.out.println(Arrays.toString(obj.ZFunction(s)));
		}
	}
}