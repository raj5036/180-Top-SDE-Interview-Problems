// O(n Log n) time and O(1) extra space 

import java.util.Arrays; 
import java.util.Comparator; 

class Interval 
{ 
	int start,end; 
	
	Interval(int start, int end) 
	{ 
		this.start=start; 
		this.end=end; 
	} 
} 

public class MergeOverlappingSubintervals2 { 
	
	public static void mergeIntervals(Interval arr[]) 
	{ 
		// Sort Intervals in decreasing order of start time 
		Arrays.sort(arr,new Comparator<Interval>(){ 
			public int compare(Interval i1,Interval i2) 
			{ 
				return i2.start - i1.start; 
			} 
		}); 
	
		int index = 0; 
		for (int i=1; i<arr.length; i++) 
		{ 
			if (arr[index].end >= arr[i].start) 
			{ 
				// Merge previous and current Intervals 
				arr[index].end = Math.max(arr[index].end, arr[i].end); 
				arr[index].start = Math.min(arr[index].start, arr[i].start); 
			} 
			else { 
				arr[index] = arr[i]; 
				index++; 
			}	 
		} 
		System.out.print("The Merged Intervals are: "); 
		for (int i = 0; i <= index; i++) 
		{ 
			System.out.print("[" + arr[i].start + ","
										+ arr[i].end + "]"); 
		} 
	} 

	// Driver Code 
	public static void main(String args[]) { 
		Interval arr[]=new Interval[4]; 
		arr[0]=new Interval(6,8); 
		arr[1]=new Interval(1,9); 
		arr[2]=new Interval(2,4); 
		arr[3]=new Interval(4,7); 
		mergeIntervals(arr); 
	} 
} 

