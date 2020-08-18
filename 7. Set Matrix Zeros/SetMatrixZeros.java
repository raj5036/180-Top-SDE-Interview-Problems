import java.util.*;
import java.util.stream.*;
public class SetMatrixZeros{

	/*Approach 1*/ //Uses extra space
	public static void setMatrixZeros(int[][] matrix){
		Set<Integer> rows=new HashSet<>();
		Set<Integer> cols=new HashSet<>();
		for(int i=0;i<matrix.length;i++)
			for (int j=0;j<matrix.length;j++)
				if(matrix[i][j]==0){
					rows.add(i);
					cols.add(j);
				}				
		
		for(int i=0;i<matrix.length;i++)
			for (int j=0;j<matrix.length;j++)
				if(rows.contains(i) || cols.contains(j))
					matrix[i][j]=0;
	}
	/*Approach 2*/
	public static void setMatrixZeros1(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]==0)
					util(matrix,i,j);
			}
		}
		for(int i=0;i<matrix.length;i++)
			for (int j=0;j<matrix[i].length;j++)
				if(matrix[i][j]==-100000)
					matrix[i][j]=0;
	}
	public static void util(int[][] matrix,int i,int j){
		int fixedRow=i;
		int fixedColumn=j;
		for(int col=0;col<matrix[fixedRow].length;col++)
			matrix[fixedRow][col]=-100000;
		for(int row=0;row<matrix.length;row++)
			matrix[row][fixedColumn]=-100000;
	}
	/*Approach 3*/ //Most Efficient
	  public static void setMatrixZeros2(int[][] matrix) {
		    Boolean isCol = false;
		    int R = matrix.length;
		    int C = matrix[0].length;

		    for (int i = 0; i < R; i++) {

		      // Since first cell for both first row and first column is the same i.e. matrix[0][0]
		      // We can use an additional variable for either the first row/column.
		      // For this solution we are using an additional variable for the first column
		      // and using matrix[0][0] for the first row.
		      if (matrix[i][0] == 0) {
		        isCol = true;
		      }

		      for (int j = 1; j < C; j++) {
		        // If an element is zero, we set the first element of the corresponding row and column to 0
		        if (matrix[i][j] == 0) {
		          matrix[0][j] = 0;
		          matrix[i][0] = 0;
		        }
		      }
		    }

		    // Iterate over the array once again and using the first row and first column, update the elements.
		    for (int i = 1; i < R; i++) {
		      for (int j = 1; j < C; j++) {
		        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
		          matrix[i][j] = 0;
		        }
		      }
		    }

		    // See if the first row needs to be set to zero as well
		    if (matrix[0][0] == 0) {
		      for (int j = 0; j < C; j++) {
		        matrix[0][j] = 0;
		      }
		    }

		    // See if the first column needs to be set to zero as well
		    if (isCol) {
		      for (int i = 0; i < R; i++) {
		        matrix[i][0] = 0;
		      }
		    }
	  }

	public static void main(String[] args){
		int[][] matrix={
						  {1,1,1},
						  {1,0,1},
						  {1,1,1}
						};
		setMatrixZeros2(matrix);
		for (int i=0;i<matrix.length;i++){
			for (int j=0;j<matrix[i].length;j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}

	}
}