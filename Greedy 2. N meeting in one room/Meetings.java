import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
	 static class Meeting{
	 int start,finish,id;
	 Meeting(int number,int s,int f){
		this.start=s;
		this.finish=f;
		this.id=number;
	 }
	 @Override 
	 public String toString(){
	 	return this.id+" ";
	 }
}
static class meet implements Comparator<meeting>{
	 @Override
	 public int compare(meeting a,meeting b){
	  if(a.finish>b.finish)
	  	return 1;
	  else if(a.finish<b.finish)
	   	return -1;
	  else{
		   if(a.start>b.start)
		   	return 1;
		  else if(a.start<b.start)
		   	return -1;
		  else
		   	return 0;
		  }
	 }
}
 public static void main (String[] args){
	 Scanner ab=new Scanner(System.in);
	 int t=ab.nextInt();
	 while(t-->0){
		  	List<meeting> lst=new ArrayList<meeting>();
		    int n=ab.nextInt();
		     int arr[]=new int[n];
		     for(int i=0;i<n;i++)
		     arr[i]=ab.nextInt();
		     int arr2[]=new int[n];
		     for(int i=0;i<n;i++)
		     arr2[i]=ab.nextInt();
	 for(int i=0;i<n;i++){
	  	lst.add(new meeting(i+1,arr[i],arr2[i]));
	 }
	 Collections.sort(lst,new meet());
	 System.out.print(lst.get(0));
	 meeting mt=lst.get(0);
	 int prev=mt.finish;
	 for(int i=1;i<n;i++)
	 {
	  mt=lst.get(i);
	  if(mt.start>prev)
	  {
	   System.out.print(mt);
	   prev=mt.finish;
	  }
	 }
	   System.out.println();
 }
}
}