import java.util.*;
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}
class LinkedList{
	Node head;
	LinkedList(){
		head=null;
	}
	Node append(Node head,int key){
		Node newNode=new Node(key);
        if(head==null)
            head=newNode;
        else{
            Node last=head;
            while(last.next!=null)
                last=last.next;
            last.next=newNode;
        }
        return head;
	}
	void printList(Node head){
		if(head==null)
			return;
		System.out.print(head.data+"->");
		printList(head.next);
	}
	boolean detectCycle(Node head){ //Space complexity:O(n)
		Node current=head;
        Set<Node> set=new HashSet<>();
        while(current!=null){
            if(set.contains(current))
                return true;
            set.add(current);
            current=current.next;
        }
        return false;
	}
	boolean detectCycle2(Node head) { //Space complexity :O(1)
		if (head==null || head.next==null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
	}
	Node detectAndRemoveLoop(Node head){ 
	    if (head == NULL || head->next == NULL) 
	        return NULL; 
	  
	    Node slow =head,fast = head; 
  
	    // Move slow and fast 1 and 2 steps 
	    // ahead respectively 
	    slow = slow.next; 
	    fast = fast.next.next; 
	  
	    // Search for loop using slow and 
	    // fast pointers 
	    while (fast && fast.next) { 
	        if (slow == fast) 
	            break; 
	        slow = slow.next; 
	        fast = fast.next.next; 
	    } 
	  
	    // If loop does not exist 
	    if (slow != fast) 
	        return NULL; 
	  
	    // If loop exists. Start slow from 
	    // head and fast from meeting point. 
	    slow = head; 
	    while (slow != fast) { 
	        slow = slow.next; 
	        fast = fast.next; 
	    } 
	  
	    return slow; 
	}
}
class Main{
	public static void main(String[] args){
		LinkedList list=new LinkedList();
		Node head=list.append(list.head,23);
		for(int data=1;data<=10;data++)
			list.append(head,data);
		list.printList(head);
	}
}