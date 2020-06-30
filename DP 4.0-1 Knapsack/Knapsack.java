import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class Knapsack{
	static int knapsack(int[] val,int[] wt,int W,int n){ //Time complexity : Exponential
		if(n==0 || W==0) // Base Case
			return 0;
		// If weight of the nth item is 
        // more than Knapsack capacity W, 
        // then this item cannot be included 
        // in the optimal solution 
		if(wt[n-1]>W)
			return knapsack(val,wt,W,n-1);
		// Return the maximum of two cases: 
        // (1) nth item included 
        // (2) not included 
		else
			return Math.max(
					val[n-1]+knapsack(val,wt,W-wt[n-1],n-1),
					knapsack(val,wt,W,n-1)
				);
	}
	static int knapSackDP(int[] val,int[] wt,int W,int n){ //Time complexity : O(n*m) //space complexity: O(n*m)

        int K[][] = new int[n + 1][W + 1]; 

        for (int i = 0; i <= n; i++)
            for (int w = 0; w <= W; w++) 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max( 
                        val[i - 1] + K[i - 1][w - wt[i - 1]], 
                        K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w];   
        return K[n][W]; 
    } 
    
	public static void main(String[] args) {
		int[] wt={10, 20, 30};
		int[] val={ 60, 100, 120 };
		int W=50;
		System.out.println(knapSackDP(val,wt,W,val.length));
	}
}