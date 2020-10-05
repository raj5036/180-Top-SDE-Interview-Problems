/*
	1  
	1 1 
	1 2 1 
	1 3 3 1 
	1 4 6 4 1 
	1 5 10 10 5 1 
*/
import java.util.*;
import java.util.stream.*;
public class Pascal{
	static int fact(int n){
		if(n==0 || n==1)
			return 1;
		return n*fact(n-1); 
	}
	static int binomialCofficient(int n,int k){
		return fact(n)/(fact(n-k)*fact(k));
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		/*Approach 1*/
		int num=-1;
		for(int i=0;i<n;i++){
			for (int j=0;j<i+1;j++){
				num=binomialCofficient(i,j);
				System.out.print(num+" ");
			}
			System.out.println();
		}
		/*Approach 2*/
		int[][] triangle=new int[n][n];
		for(int i=0;i<n;i++){
			for (int j=0;j<i+1;j++){
				if(j==0 || j==i)
					triangle[i][j]=1;
				else
					triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
				System.out.print(triangle[i][j]+" ");
			}
			System.out.println();
		}
		/*Approach 3*/
		for(int line = 1; line <= n; line++) { 
	          
		    int C=1;// used to represent C(line, i) 
		    for(int i = 1; i <= line; i++){  
		        // The first value in a line is always 1 
		        System.out.print(C+" "); 
		        C = C * (line - i) / i;  
		    } 
		    System.out.println(); 
	    }
	}
}