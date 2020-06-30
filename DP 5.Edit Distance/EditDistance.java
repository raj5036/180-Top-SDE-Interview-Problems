import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class EditDistance{
	static int editDistance(String a,String b,int m,int n){ //Time complexity :O(3^m) //Exponential
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(a.charAt(m-1)==b.charAt(n-1))
			return editDistance(a,b,m-1,n-1);
		return 1+Math.min(
				editDistance(a,b,m-1,n), //Remove
				Math.min(
						editDistance(a,b,m,n-1), //Insert
						editDistance(a,b,m-1,n-1) //Replace
					)
			);
	}
	static int editDistanceDP(String a,String b,int m,int n){ //Time complexity : O(m*n) //space complexity : O(m*n)
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<=m; i++)
			for (int j=0;j<=n;j++)
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
		return dp[m][n];
	}
	public static void main(String[] args) {
		String a="sunday";
		String b="saturday";
		System.out.println(editDistance(a,b,a.length(),b.length()));
		System.out.println(editDistanceDP(a,b,a.length(),b.length()));
	}
}