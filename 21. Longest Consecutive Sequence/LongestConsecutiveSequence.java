import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class LongestConsecutiveSequence {
	static int maxLen(int[] a,int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		int len=1,maxLen=Integer.MIN_VALUE;
		List<Integer> list=new ArrayList<>();
		for(int num:a)
			list.add(num);
		for(int i=0;i<list.size();i++){
			int ele=list.get(i);
			while(list.contains(ele+1)){
				len++;
				ele++;
			}
			maxLen=Integer.max(maxLen,len);
			len=1;
		}
		return maxLen;
	}
	static int longestConsecutive(int[] nums) {
        int maxLen=0;
        Set<Integer> set=IntStream.of(nums).boxed().collect(Collectors.toSet());
        for(int num:nums){
            if(!set.contains(num-1)){
                int len=1;
                while(set.contains(num+len))
                    len++;
                maxLen=Math.max(len,maxLen);
            }
        }
        return maxLen;
    }
	public static void main(String[] args){
		int[] a={100, 4, 200, 1, 3, 2};
		/*Approach 1*/ //Incorrect
		Arrays.sort(a);
		int n=a.length,len=0;
		for (int i=0;i<n-1;i++)
			if(a[i]<a[i+1])
				len++;
		System.out.println(len-1);

		/*Approach 2*/ //TLE in LeetCode
		System.out.println(maxLen(a,n));
		
		/*Approach 3*/ //Best
		System.out.println(longestConsecutive(a));
	}	
}