/*LeetCode Solution*/
class Solution {
    public int maxProfit(int[] prices) {        
        int n=prices.length;
        if(n==0 || n==1)
            return 0;
        int profit=0,maxProfit=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++){
                if(prices[j]>prices[i])
                    profit=prices[j]-prices[i];
                maxProfit=Integer.max(maxProfit,profit);
            } 
        return maxProfit;
    }
}