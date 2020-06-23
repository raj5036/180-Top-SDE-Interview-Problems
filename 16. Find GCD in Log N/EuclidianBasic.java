import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class EuclidianBasic{
	static int euclidian(int a,int b){ //Time complexity : O(Log( min(a,b) ))
		if(a==0)
			return b;
		return euclidian(b%a,a);
	}
	/*
		Extended Euclidean Algorithm:
		Extended Euclidean algorithm also finds integer coefficients x and y such that:

	  	ax + by = gcd(a, b) 
  	*/
	  	static int gcdExtended(int a,int b,int x,int y){
	  		if(a==0){
	  			x=0;
	  			y=1;
	  			return b;
	  		}
	  		int x1=1,y1=1;
	  		int gcd=gcdExtended(b%a,b,x1,y1);
	  		x=y1-(b/a)*x1;
	  		y=x1;
	  		System.out.println(x1+" "+y1);
	  		return gcd;
	  	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		/*Approach 1*/
		System.out.println(euclidian(a,b));
	    
		System.out.println(gcdExtended(30,20,1,1));
	}
}