/*Given an array of integers, return indices of the two numbers such that they add up to a specific target*/
import java.util.*;
import java.lang.*;
import java.util.stream.*;
public class TwoSum{
	static int[] twoSum(int[] a,int target){
		int n=a.length;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(a[i]+a[j]==target)
					return new int[]{i,j};
		return new int[]{-1};
	}
	static int[] twoSum1(int[] a,int target){
		int n=a.length;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
			if(!map.containsKey(a[i]))
				map.put(a[i],i);
		for(int i=0;i<n;i++){
			int complement=target-a[i];
			if(map.containsKey(complement) && map.get(complement)!=i)
				return new int[]{i,map.get(complement)};
		}
		return new int[]{-1};
	}
	//One-Pass Solution
	public int[] twoSum2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	public static void main(String[] args){
		int[] a={2, 7, 11, 15};
		int target=9;
		/*Approach 1*/
		int[] ans=twoSum(a,target);
		System.out.println(Arrays.toString(ans));
		System.out.println(Arrays.toString(twoSum1(a,target)));
	}
}