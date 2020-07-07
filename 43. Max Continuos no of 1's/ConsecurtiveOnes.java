class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length,count=0,maxCount=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) 
                count++;
            else
                count=0;
            maxCount=Integer.max(count,maxCount);
        }
        return maxCount;
    }
}