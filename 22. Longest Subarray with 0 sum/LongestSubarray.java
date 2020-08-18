import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class LongestSubarray{
	static int longestSubarray(int arr[], int n) { //Brute Force
        int max_len = 0; 
        for (int i = 0; i < n; i++) { 
            int curr_sum = 0;  
            for (int j = i; j < n; j++) { 
                curr_sum += arr[j];  
                if (curr_sum == 0) 
                    max_len = Math.max(max_len, j - i + 1); 
            } 
        } 
        return max_len; 
    } 
    static int maxLen(int arr[]) {  //Time complexity : O(n)
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 
        int sum = 0; 
        int max_len = 0; 
  
        for (int i = 0; i < arr.length; i++) { 
            sum += arr[i]; 
  
            if (arr[i] == 0 && max_len == 0) 
                max_len = 1; 

            if (sum == 0) 
                max_len = i + 1; 
 
            Integer prev_i = hM.get(sum); 
            if (prev_i != null) 
                max_len = Math.max(max_len, i - prev_i); 
            else 
                hM.put(sum, i); 
            return max_len;
        }
    } 
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.println(longestSubarray(a,n));
		//{15, -2, 2, -8, 1, 7, 10, 23};
		//{-8, -2, 1, 2, 7, 10, 15, 23};
	}
}