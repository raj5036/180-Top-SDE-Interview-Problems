#include<bits/stdc++.h> 
using namespace std; 

struct Interval 
{ 
	int start, end; 
}; 

// Compares two intervals according to their staring time. 
// This is needed for sorting the intervals using library 
// function std::sort(). See http://goo.gl/iGspV 
bool compareInterval(Interval i1, Interval i2) 
{ 
	return (i1.start < i2.start); 
} 

// The main function that takes a set of intervals, merges 
// overlapping intervals and prints the result 
void mergeIntervals(Interval arr[], int n) 
{ 
	if (n <= 0) 
		return; 

	// Create an empty stack of intervals 
	stack<Interval> s; 

	// sort the intervals in increasing order of start time 
	sort(arr, arr+n, compareInterval); 

	// push the first interval to stack 
	s.push(arr[0]); 
 
	for (int i = 1 ; i < n; i++) {  
		Interval top = s.top(); 

		// if current interval is not overlapping with stack top, 
		// push it to the stack 
		if (top.end < arr[i].start) 
			s.push(arr[i]); 

		else if (top.end < arr[i].end) 
		{ 
			top.end = arr[i].end; 
			s.pop(); 
			s.push(top); 
		} 
	} 

	// Print contents of stack 
	cout << "\n The Merged Intervals are: "; 
	while (!s.empty()) 
	{ 
		Interval t = s.top(); 
		cout << "[" << t.start << "," << t.end << "] "; 
		s.pop(); 
	} 
	return; 
}
void mergeIntervals(Interval arr[], int n)  
{  
    // Sort Intervals in increasing order of 
    // start time 
    sort(arr, arr+n, compareInterval);  
  
    int index = 0; // Stores index of last element  
    // in output array (modified arr[])  
  
    // Traverse all input Intervals  
    for (int i=1; i<n; i++)  
    {  
        // If this is not first Interval and overlaps  
        // with the previous one  
        if (arr[index].e >=  arr[i].s)  
        {  
               // Merge previous and current Intervals  
            arr[index].e = max(arr[index].e, arr[i].e);  
            arr[index].s = min(arr[index].s, arr[i].s);  
        }  
        else { 
            arr[index] = arr[i];  
            index++; 
        }     
    }  
  
    // Now arr[0..index-1] stores the merged Intervals  
    cout << "\n The Merged Intervals are: ";  
    for (int i = 0; i <= index; i++)  
        cout << "[" << arr[i].s << ", " << arr[i].e << "] ";  
}  


// Driver program 
int main() 
{ 
	Interval arr[] = { {6,8}, {1,9}, {2,4}, {4,7} }; 
	int n = sizeof(arr)/sizeof(arr[0]); 
	mergeIntervals(arr, n); 
	return 0; 
} 
