#include <bits/stdc++.h> 
using namespace std; 

long long subarrayXor(int arr[], int n, int m) { 
	long long ans = 0; 

	for (int i = 0; i < n; i++) { 
		int xorSum = 0; 

		for (int j = i; j < n; j++) { 

			xorSum = xorSum ^ arr[j]; 

			if (xorSum == m) 
				ans++; 
		} 
	} 
	return ans; 
}
long long subarrayXor(int arr[], int n, int m) 
{ 
    long long ans = 0; // Initialize answer to be returned 
  
    // Create a prefix xor-sum array such that 
    // xorArr[i] has value equal to XOR 
    // of all elements in arr[0 ..... i] 
    int* xorArr = new int[n]; 
  
    // Create map that stores number of prefix array 
    // elements corresponding to a XOR value 
    unordered_map<int, int> mp; 
  
    // Initialize first element of prefix array 
    xorArr[0] = arr[0]; 
  
    // Computing the prefix array. 
    for (int i = 1; i < n; i++) 
        xorArr[i] = xorArr[i - 1] ^ arr[i]; 
  
    // Calculate the answer 
    for (int i = 0; i < n; i++) { 
        // Find XOR of current prefix with m. 
        int tmp = m ^ xorArr[i]; 
  
        // If above XOR exists in map, then there 
        // is another previous prefix with same 
        // XOR, i.e., there is a subarray ending 
        // at i with XOR equal to m. 
        ans = ans + ((long long)mp[tmp]); 
  
        // If this subarray has XOR equal to m itself. 
        if (xorArr[i] == m) 
            ans++; 
  
        // Add the XOR of this subarray to the map 
        mp[xorArr[i]]++; 
    } 
  
    // Return total count of subarrays having XOR of 
    // elements as given value m 
    return ans; 
}  

int main(){ 
	int arr[] = { 4, 2, 2, 6, 4 }; 
	int n = sizeof(arr) / sizeof(arr[0]); 
	int m = 6; 

	cout << "Number of subarrays having given XOR is "
		<< subarrayXor(arr, n, m); 
	return 0; 
} 

