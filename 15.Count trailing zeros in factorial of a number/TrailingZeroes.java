<<<<<<< HEAD
import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class TrailingZeroes{
	static int fact(int n){
		if(n==0 || n==1)
			return 1;
		return n*fact(n-1);
	}
	static int trailingZeroes(int num){
		int n=fact(num);
		System.out.println(n);
		int count=0;
		do{
			int digit=n%10;
			if(digit==0) 
				count++;
			else
				break;
			n=n/10;
		}while(n!=0);
		return count;
	}
	static int findTrailingZeros(int n){
        int count = 0; 
        // Keep dividing n by powers  
        // of 5 and update count 
        for (int i = 5; n / i >= 1; i *= 5) 
            count += n / i; 
  
        return count; 
    } 
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(trailingZeroes(n));
	}
=======
import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class TrailingZeroes{
	static int fact(int n){
		if(n==0 || n==1)
			return 1;
		return n*fact(n-1);
	}
	static int trailingZeroes(int num){
		int n=fact(num);
		System.out.println(n);
		int count=0;
		do{
			int digit=n%10;
			if(digit==0) 
				count++;
			else
				break;
			n=n/10;
		}while(n!=0);
		return count;
	}
	static int findTrailingZeros(int n) {
		int count = 0; 
		// Keep dividing n by powers  
		// of 5 and update count 
		for (int i = 5; n / i >= 1; i *= 5) 
		    count += n / i; 
	  
		return count; 
    	} 
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(trailingZeroes(n));
	}
>>>>>>> a0e259894785f341e7bf34e7f7c4143b02f2eb3a
}