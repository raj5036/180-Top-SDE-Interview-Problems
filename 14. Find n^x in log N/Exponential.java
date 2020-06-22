import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class Exponential{
	static int getPower(int x,int y){
		if(y==0)
			return 1;
		if(y==1)
			return x;
		else if(y%2==0)
			return getPower(x,y/2)*getPower(x,y/2);
		else
			return x*getPower(x,y/2)*getPower(x,y/2);
	}
	static int getPowerDP(int x,int y,Map<Integer,Integer> lookUp){
		// Key->power value->value
		if(y==0)
			return 1;
		if(y==1)
			return x;
		if(!lookUp.containsKey(y)){
			lookUp.put(y,getPowerDP(x,y/2,lookUp));
			if(y%2==0)
				return lookUp.get(y)*lookUp.get(y);
			else
				return x*lookUp.get(y)*lookUp.get(y);
		}
		return lookUp.get(y);
	}
	static float power(float x, int y) { 
        float temp; 
        if(y == 0) 
            return 1; 
        temp = power(x, y/2);      
        if (y%2 == 0) 
            return temp*temp; 
        else{ 
            if(y > 0) 
                return x * temp * temp; 
            else
                return (temp * temp) / x; 
        } 
    }  
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		/*Approach 1*/
		int ans=1;
		for(int i=0;i<m;i++)
			ans*=n;
		System.out.println(ans);
		/*Approach 2*/
		System.out.println(getPower(n,m));
		/*Approach*/ //Use DP
		Map<Integer,Integer> lookUp=new HashMap<>();
		System.out.println(getPowerDP(n,m,lookUp));
	}
}