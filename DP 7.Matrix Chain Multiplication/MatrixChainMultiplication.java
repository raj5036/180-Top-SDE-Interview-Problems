import java.util.*;
public class MatrixChainMultiplication{
	public int matrixChainMultiplication(int[] dims,int i,int j){
		// base case: one matrix
		if (j <= i + 1) {
			return 0;
		}
		// stores minimum number of scalar multiplications (i.e., cost)
		// needed to compute the matrix M[i+1]...M[j] = M[i..j]
		int min = Integer.MAX_VALUE;

		// take the minimum over each possible position at which the
		// sequence of matrices can be split

		/*
			(M[i+1]) x (M[i+2]..................M[j])
			(M[i+1]M[i+2]) x (M[i+3.............M[j])
			...
			...
			(M[i+1]M[i+2]............M[j-1]) x (M[j])
		*/

		for (int k = i + 1; k <= j - 1; k++)
		{
			// recur for M[i+1]..M[k] to get a i x k matrix
			int cost = matrixChainMultiplication(dims, i, k);

			// recur for M[k+1]..M[j] to get a k x j matrix
			cost += matrixChainMultiplication(dims, k, j);

			// cost to multiply two (i x k) and (k x j) matrix
			cost += dims[i] * dims[k] * dims[j];

			if (cost < min) {
				min = cost;
			}
		}

		// return min cost to multiply M[j+1]..M[j]
		return min;
	}
	public int matrixChainMultiplication(int[] dims,int i,int j,int[][] T){
		if(j<=i+1)
			return 0;
		int min=Integer.MAX_VALUE;
		if(T[i][j]==0){
			for(int k=i+1;k<=j-1;k++){
				int cost=matrixChainMultiplication(dims,i,k,T);
				cost+=matrixChainMultiplication(dims,k,j,T);
				cost+=dims[i]*dims[j]*dims[k];
				if(cost<min)
					min=cost;
			}
			T[i][j]=min;
		}
		return T[i][j];
	}
	public static void main(String[] args){
		MatrixChainMultiplication obj=new MatrixChainMultiplication();
		int[] dims={10, 30, 5, 60};
		int n=dims.length;
		System.out.println(obj.matrixChainMultiplication(dims,0,n-1));
		int[][] T=new int[n][n];
		System.out.println(obj.matrixChainMultiplication(dims,0,n-1,T)); //DP
		for(int[] row:T)
			System.out.println(Arrays.toString(row));
	}
}