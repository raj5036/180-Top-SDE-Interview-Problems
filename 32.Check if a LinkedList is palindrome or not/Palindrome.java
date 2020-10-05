import java.util.*;
import java.util.stream.*;
public class Palindrome{
	boolean isPalindrome(Node head){ //Time complexity :O(n)  Space complexity:O(n)
		Stack<Integer> stack=new Stack<>();
		Node cur=head;
		while(cur!=null){
			stack.push(cur.data);
			cur=cur.next;
		}
		cur=head;
		boolean isPalindrome=true;
		while(cur!=null){
			int i=stack.pop();
			if(i==cur.data)
				isPalindrome=true;
			else{
				isPalindrome=false;
				break;
			}
			cur=cur.next;
		}
		return isPalindrome;
	}
	boolean isPalindrome(Node head) { 
        slow_ptr = head; 
        fast_ptr = head; 
        Node prev_of_slow_ptr = head; 
        Node midnode = null; // To handle odd size list 
        boolean res = true; // initialize result 
  
        if (head != null && head.next != null) { 
            /* Get the middle of the list. Move slow_ptr by 1 
               and fast_ptrr by 2, slow_ptr will have the middle 
               node */
            while (fast_ptr != null && fast_ptr.next != null) { 
                fast_ptr = fast_ptr.next.next; 
  
                /*We need previous of the slow_ptr for 
                  linked lists  with odd elements */
                prev_of_slow_ptr = slow_ptr; 
                slow_ptr = slow_ptr.next; 
            } 
  
            /* fast_ptr would become NULL when there are even elements  
               in the list and not NULL for odd elements. We need to skip   
               the middle node for odd case and store it somewhere so that 
               we can restore the original list */
            if (fast_ptr != null) { 
                midnode = slow_ptr; 
                slow_ptr = slow_ptr.next; 
            } 
  
            // Now reverse the second half and compare it with first half 
            second_half = slow_ptr; 
            prev_of_slow_ptr.next = null; // NULL terminate first half 
            reverse(); // Reverse the second half 
            res = compareLists(head, second_half); // compare 
  
            /* Construct the original list back */
            reverse(); // Reverse the second half again 
  
            if (midnode != null) { 
                // If there was a mid node (odd size case) which 
                // was not part of either first half or second half. 
                prev_of_slow_ptr.next = midnode; 
                midnode.next = second_half; 
            } 
            else
                prev_of_slow_ptr.next = second_half; 
        } 
        return res; 
    } 
    void reverse(){ 
        Node prev = null; 
        Node current = second_half; 
        Node next; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        second_half = prev; 
    } 
	public static void main(String[] args){

	}
}