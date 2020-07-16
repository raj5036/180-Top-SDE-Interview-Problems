//My LeetCode Solution
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i : nums1)
            pq.add(i);
        for(int i : nums2)
            pq.add(i);
        int[] ans=new int[nums1.length+nums2.length];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll();
        }
        if(ans.length%2==1)
            return ans[ans.length/2];
        else{
            int a=ans[(ans.length/2)-1];
            int b=ans[ans.length/2];
            return (double)(a+b)/2;
        }
    }
}