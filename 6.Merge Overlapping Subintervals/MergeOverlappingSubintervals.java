import java.util.*;
import java.util.stream.*;
class Interval{
	int start,end;
	Interval(int start,int end){
		this.start=start;
		this.end=end;
	}
}
public class MergeOverlappingSubintervals{
	static void mergeOverlappingSubintervals(Interval[] a){
		int n=a.length;
		if(n<=0)
			return;
		Stack<Interval> stack=new Stack<>();
		//Sort the intervals in the Increasing order of their starting time
		Arrays.sort(a,new Comparator<Interval>(){
			public int compare(Interval a,Interval b){
				return a.start-b.start;
			}
		});
		stack.push(a[0]);
		for (int i=1;i<n;i++){
			// get interval from stack top  
            Interval top = stack.peek();  
    
            // if current interval is not overlapping with stack top,  
            // push it to the stack  
            if (top.end < a[i].start)  
                stack.push(a[i]);  
    
            // Otherwise update the ending time of top if ending of current  
            // interval is more  
            else if (top.end < a[i].end)  
            {  
                top.end = a[i].end;  
                stack.pop();  
                stack.push(top);  
            } 
		}
		while(!stack.isEmpty()){
			Interval top=stack.pop();
			System.out.print("{"+top.start+","+top.end+"}");
		}
	}
	public static void main(String[] args){
		Interval[] a=new Interval[4];
		a[0]=new Interval(6,8); 
        a[1]=new Interval(1,9); 
        a[2]=new Interval(2,4); 
        a[3]=new Interval(4,7);
        mergeOverlappingSubintervals(a); 
	}
}