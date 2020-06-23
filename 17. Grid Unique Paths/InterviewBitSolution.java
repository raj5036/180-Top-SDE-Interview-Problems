/*TLE*/
class Solution {
    int solve(int[][] grid, int x, int y){
        if(x>=grid.length || y >=grid[0].length) return 0;
        if(x == grid.length-1 && y == grid[0].length-1) return 1;
        return solve(grid,x+1,y) + solve(grid,x,y+1); 
    }
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        return solve(grid,0,0);
    }
}
/*Using DP*/
class Solution { //Best Solution
    int[][] memo;
    
    int solve(int[][] grid, int x, int y){
        if(x>=grid.length || y >=grid[0].length) return 0;
        if(memo[x][y] != -1) return memo[x][y];
        if(x == grid.length-1 && y == grid[0].length-1) return 1;
        return memo[x][y] = solve(grid,x+1,y) + solve(grid,x,y+1); 
    }
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        memo = new int[m][n];
        for(int[]rows:memo) Arrays.fill(rows,-1);
        return solve(grid,0,0);
    }
}
/*Optimized*/
class InterviewBitSolution {
	public int uniquePaths(int a, int b) {
	      /* If either 1 row or 1 column are there then the only way to end
	         is to traverse through that row or column respectively.*/
	    if(a==1 || b==1)
	      return 1;
	      /*If there are more than one row and column then u need to move 
	        either right or down reducing one row or one column respectively
	        and adding that way in answer*/
	    else{
	        int ans = 0;
	        ans = uniquePaths(a-1,b)+uniquePaths(a,b-1);
	        return ans;
	    }
	}
}