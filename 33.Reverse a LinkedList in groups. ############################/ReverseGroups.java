import java.util.*;
import java.util.stream.*;
public class ReverseGroups{
	public static Node reverse(Node head, int k){
	    if(k==0 || k==1) return head;
        Node current=head;
        Node prev=null,next=null;
       
        int count=0;
        
        while(current!=null &&count<k){
            next=current.next;
            current.next=prev;
            
            prev=current;
            current=next;
            
            count++;
        }
        if(next!=null) 
            head.next=reverse(next,k);
        return prev;
    }
}