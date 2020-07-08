import java.util.*;
import java.util.stream.*;
class CoinChange{
	static List<Integer> denominations=new ArrayList<>(Arrays.asList(new Integer[]{1,2,5,10,20,50,100,500,1000}));
	static int size=denominations.size();	
	int getHighestPossibleCurrency(List<Integer> denominations,int n,int i){
		if(i<0)
			return 0;
		if(denominations.get(i)>n)
			return getHighestPossibleCurrency(denominations,n,i-1);
		return denominations.get(i);
	}
	int getNoOfCoins(int value,int noOfCoins){
		if(value<=0)
			return noOfCoins;
		int updatedvalue=value-getHighestPossibleCurrency(denominations,value,size-1);
		noOfCoins++;
		return getNoOfCoins(updatedvalue,noOfCoins);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int value=sc.nextInt();
		CoinChange obj=new CoinChange();
		System.out.println(obj.getNoOfCoins(value,0));
	}
}