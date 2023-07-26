
public class DoublyCircularlist {
	
	
		static class Node{
			private int data;
			private Node next;
			private Node prev;
			public Node() {
				data = 0;
				next = null;
				prev = null;
			}
			public Node(int value) {
				data = value;
				next = null;
				prev = null;
			}
		}
		
		private Node head;
		public DoublyCircularlist() {
			head = null;
		}
		
		public boolean isEmpty() {
			return head == null;
		}
		
		public void displayForward() {
			Node trav = head;
			System.out.print(" Fwd List : ");
			do {
				System.out.print(" " + trav.data);
				trav = trav.next;
			}while(trav != head);
			System.out.println("");
		}
		
		public void displayReverse() {
			Node trav = head.prev;
			System.out.print("Rev List : ");
			do {
				System.out.print(" " + trav.data);
				trav = trav.prev;
			}while(trav != head.prev);
			System.out.println("");
		}
		
		public void addFirst(int value) {
			Node nn = new Node(value);
			if(isEmpty()) {
				head = nn;
				nn.next = nn;
				nn.prev = nn;
			}else {
				nn.next = head;
				nn.prev = head.prev;
				head.prev.next = nn;
				head.prev = nn;
				head = nn;
			}
		}
		
		public void addLast(int value) {
			Node nn = new Node(value);
			if(isEmpty()) {
				head = nn;
				nn.next = nn;
				nn.prev = nn;
			}else {
				nn.next = head;
				nn.prev = head.prev;
				head.prev.next = nn;
				head.prev = nn;
			}
		}
		
		void addPos(int value,int pos) {
			Node nn = new Node(value);
			if (head == null || pos<1) {
				nn.next = nn.prev = nn;
				head = nn;
				return;
			} else {
				Node temp=null;
				Node trav=head;
				for(int i=1;i<pos;i++) {
					if(trav.next==head)
						break;
					temp=trav;
					trav=trav.next;
				}
				nn.prev=temp;
				nn.next=trav;
				temp.next=nn;
				trav.prev=nn;
				
			}
		}
	
		public void delFirst() {
			if(isEmpty())
				return;
			else if(head.next == head)
				head = null;
			else {
				head.prev.next = head.next;
				head.next.prev = head.prev;
				head = head.next;
			}
		}
		
		public void delLast() {
			if(isEmpty())
				return;
			else if(head.next == head)
				head = null;
			else {
				head.prev = head.prev.prev;
				head.prev.next = head;
			}
		}
		
		void deletePos(int pos) {
			if (head == null || pos<1) {
				System.out.println("list is empty");
				return;
			} else {
				Node temp=null;
				Node trav=head;
				for(int i=1;i<pos;i++) {
					if(trav.next==head)
						break;
					temp=trav;
					trav=trav.next;
				}
				Node temp2=trav.next;
				temp2.prev=temp;
				temp.next=temp2;
				
			}
		}

		public void delAll() {
			head = null;
		}
		
	}









	


