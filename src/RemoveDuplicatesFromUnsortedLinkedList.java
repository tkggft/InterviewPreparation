import java.util.HashSet;


public class RemoveDuplicatesFromUnsortedLinkedList {
	public static ListNode RemoveDuplicates(ListNode l) {
		HashSet<Integer> nodes = new HashSet<Integer>();
		ListNode pre = null;
		ListNode FakeHead = new ListNode(-1);
		FakeHead.next = l;
		
		while( l != null ) {
			if( nodes.contains(l.data) ) 
				pre.next = l.next;
			else {
				nodes.add(l.data);
				pre = l;
			}
			l = l.next;
		}
		
		return FakeHead.next;
	}
	
	public static ListNode RemoveDuplicates2(ListNode l) {
		if( l == null )
			return l;
		
		ListNode later = null;
		ListNode FakeHead = new ListNode(-1);
		FakeHead.next = l;
		
		while( l != null ) {
			later = l;
			while( later.next != null ) {
				if( l.data == later.next.data  ) 
					later.next = later.next.next;
				else 
					later = later.next;
			}
			l = l.next;
		}
		
		return FakeHead.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);	ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);	ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);	ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(2);	ListNode l8 = new ListNode(3);
		l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;
		l5.next = l6; l6.next = l7; l7.next = l8; l8.next = null;
		
		System.out.println("Before removing: ");
		l1.PrintList();
		System.out.println();
		System.out.println("After removing: ");
		ListNode NewList = RemoveDuplicates(l1);
		NewList.PrintList();

		System.out.println();
		System.out.println("After removing(without buffer): ");
		ListNode NewList2 = RemoveDuplicates(l1);
		NewList2.PrintList();
	}
	
}

class ListNode {
	int data;
	ListNode next;
	
	ListNode(int i) {
		this.data = i;
	}
	@SuppressWarnings("unused")
	public void PrintList() {
		ListNode l = this;
		if( l == null )
			System.out.println("No node in list!");
		
		while( l != null ) {
			System.out.print(l.data + "->");
			l = l.next;
		}
		
		System.out.println("null"); // list end
	}
}