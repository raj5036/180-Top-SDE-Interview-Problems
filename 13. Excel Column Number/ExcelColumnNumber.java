/*
    KEY IDEA
    --------------
    To convert CDA,
    3*26*26 + 4*26 + 1
    = 26(3*26 + 4) + 1
    = 26(0*26 + 3*26 + 4) + 1
*/
import java.util.*;
import java.util.stream.*;
import java.lang.*;
class Solution {
    static int getChar(char[] charCount,char c){
        for(int i=0;i<26;i++)
                if(charCount[i]==c)
                    return i+1;
        return -1;
    }
    static public int titleToNumber(String s) {
        char c='A';
        char[] charCount=new char[26];
        for(int i=0;i<charCount.length;i++)
            charCount[i]=c++;
        //System.out.println(Arrays.toString(charCount));
        int ans=0;
        int power=s.length()-1;
        for(int i=0;i<s.length()-1;i++){
            int pos=getChar(charCount,s.charAt(i));
            ans+=pos*Math.pow(26,power--);
        }
        ans+=getChar(charCount,s.charAt(s.length()-1));
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(titleToNumber(s));
    }
}