import java.util.*;
import java.util.stream.*;
import java.lang.*;o
public class longestSubstring{
	//TLE
	boolean isRepeating(String s){
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray())
            if(!set.contains(c))
                set.add(c);
             else
                 return true;
        set.clear();
        return false;
    }
    public int lengthOfLongestSubstring(String s) {
        int len=1,maxLen=1,n=s.length();
        if(n==0)
            return 0;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++){
                if(!isRepeating(s.substring(i,j+1)))
                    len=s.substring(i,j+1).length();
                maxLen=Integer.max(maxLen,len);
            }
        return maxLen;
    }
    //O(2*n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    //O(n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}