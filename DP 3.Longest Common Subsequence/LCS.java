import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class LCS{
	static int LCSLength(String a,String b,int m,int n){
		if(m==0 || n==0)
			return 0;
		if(a.charAt(m-1)==b.charAt(n-1))
			return LCSLength(a,b,m-1,n-1)+1;
		return Math.max(LCSLength(a,b,m-1,n),LCSLength(a,b,m,n-1));
	}
	static int LCSLengthDP(String a,String b,int m,int n,Map<String,Integer> lookUp){
		if(m==0|| n==0)
			return 0; 
		String key=m+"|"+n;
		if(!lookUp.containsKey(key)){
			if(a.charAt(m-1)==b.charAt(n-1))
				lookUp.put(key,LCSLengthDP(a,b,m-1,n-1,lookUp)+1);
			else
				lookUp.put(key,Math.max(LCSLengthDP(a,b,m-1,n,lookUp), LCSLengthDP(a,b,m,n-1,lookUp)));
		}
		return lookUp.get(key);
	}
	static int LCSLengthDP2(String a,String b,int m,int n){
		int[][] lookUp=new int[m+1][n+1];
		for(int i=1;i<lookUp.length;i++)
			for(int j=1;j<lookUp[i].length;j++)
				if(a.charAt(i-1)==b.charAt(j-1))
					lookUp[i][j]=lookUp[i-1][j-1]+1;
				else
					lookUp[i][j]=Math.max(lookUp[i-1][j],lookUp[i][j-1]);
		return lookUp[m][n];
	}
	public static void main(String[] args){
		String a="kellyC";
		String b="aklelqwyC";
		int n=LCSLength(a,b,a.length(),b.length());
		Map<String,Integer> lookUp = new HashMap<>();
		System.out.println(LCSLengthDP(a,b,a.length(),b.length(),lookUp));
		System.out.println(LCSLengthDP2(a,b,a.length(),b.length()));
	}
}