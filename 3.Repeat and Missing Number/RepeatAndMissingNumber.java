import java.util.*;
import java.util.stream.*;
public class RepeatAndMissingNumber{
	static void printTwoElements(int a[], int n) { 
        System.out.println("The repeating element is "); 
  
        for (int i = 0; i < n; i++) {  
            if (a[Math.abs(a[i])-1] > 0) 
                a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1]; 
            else
                System.out.println(Math.abs(a[i])); 
        } 
  
        System.out.print("And the missing element is "); 
        for (int i=0;i<n;i++){ 
            if (a[i]>0) 
                System.out.println(i + 1); 
        } 
    }

	public static void main(String[] args){
		int[] a={7, 3, 4, 5, 5, 6, 2};
		printTwoElements(a,a.length);
	}
}