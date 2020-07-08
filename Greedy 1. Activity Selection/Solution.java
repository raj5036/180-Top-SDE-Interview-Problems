import java.util.*;
import java.lang.*;
import java.io.*;
//my approach (Compilation error)
class Activity{
    int start;
    int end;
    int id;
    Activity(int start,int end,int id){
        this.start=start;
        this.end=end;
        this.id=id;
    }
}
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int n=sc.nextInt();
	        List<Activity> activity=new ArrayList<>();
	        int[] startingTimes=new int[n];
	        int[] endingTimes=new int[n];
	        for(int i=0;i<n;i++)
	            startingTimes[i]=sc.nextInt();
            for(int i=0;i<n;i++)
                endingTimes[i]=sc.nextInt();
	        for(int i=0;i<n;i++)
	            activity.get(i)=new Activity(startingTimes[i],endingTimes[i],i+1);
	            
            Collections.sort(activity,new Comparator<Activity>(){
                public int compare(Activity a1,Activity a2){
                    return a1.start-a2.start;
                }
            });
            
            int index=1;
            System.out.print( activity.get(index).id );
            while(index<activity.size()){
                if( activity.get(index-1).end<activity.get(index).start ){ //valid
                    System.out.print( activity.get(index).id );
                }else{ //Overlapping
                    activity.remove(index);
                }
                index++;
            }
	    }
	}
}




// The following implementation assumes that the activities 
// are already sorted according to their finish time 

class ActivitySelection { 
    // Prints a maximum set of activities that can be done by a single 
    // person, one at a time. 
    // n --> Total number of activities 
    // s[] --> An array that contains start time of all activities 
    // f[] --> An array that contains finish time of all activities 
    public static void printMaxActivities(int s[], int f[], int n) { 
        int i, j; 
        
        System.out.print("Following activities are selected : n"); 
        
        // The first activity always gets selected 
        i = 0; 
        System.out.print(i+" "); 
        
        // Consider rest of the activities 
        for (j = 1; j < n; j++) 
        { 
            // If this activity has start time greater than or 
            // equal to the finish time of previously selected 
            // activity, then select it 
            if (s[j] >= f[i]) 
            { 
                System.out.print(j+" "); 
                i = j; 
            } 
        } 
    } 
    
    // driver program to test above function 
    public static void main(String[] args) 
    { 
        int s[] = {1, 3, 0, 5, 8, 5}; 
        int f[] = {2, 4, 6, 7, 9, 9}; 
        int n = s.length; 
            
        printMaxActivities(s, f, n); 
    } 
    
} 
