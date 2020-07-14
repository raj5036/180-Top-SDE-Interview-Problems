import java.util.*;
class Solution{
	boolean isPalindrome(String s){
		if(s.length()==0)
			return false;
		int n = s.length();
		int i=0,j=n-1;
		while(i<=j){
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	int minCharacters(String s){
		if(isPalindrome(s))
			return 0;
		int i=0,j=1,n=s.length(),max_len=0,cur_len=-1;
		String palindrome="";
		while(i<n && j<n){
			if(isPalindrome(s.substring(i,j+1))){
				String temp=s.substring(i,j+1);
				cur_len=temp.length();

				if(cur_len>max_len)
					palindrome=temp;
			}
			else if(j==n-1 && i<n){
				i++;
				j=i+1;
			}
			else
				j++;
		}
		if(palindrome.length()==0)
			if(n%2==0)
				return n;
			else
				return n-1;
		else{
			
		}
	}
	public static void main(String[] args){
		Solution obj=new Solution();
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			System.out.println(obj.minCharacters(s));
		}
	}
}