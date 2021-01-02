import java.util.Scanner;

public class LinkedListUse {
	
	private static Node<Integer> takeInput() {
		Scanner scan = new Scanner(System.in);
		Node<Integer> head = null, tail = null;
		int data = scan.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null && tail == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = tail.next;
			}
			data = scan.nextInt();
		}
		return head;
	}

	private static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	private static Node<Integer> insert(Node<Integer> head, int data, int pos) {
		if(pos == 0) {
			Node<Integer> newNode = new Node<Integer>(data);
			newNode.next = head;
			head = newNode;
			return head;
		}
		
		Node<Integer> newNode = new Node<Integer>(data);
		int i = 0;
		Node<Integer> temp = head;
		while(i < pos - 1) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	
	public static void main(String[] args) {

		Node<Integer> node1 = new Node<Integer>(10);
		System.out.println(node1.data); // 10
		System.out.println(node1.next); // null
		
		Node<Integer> node2 = new Node<Integer>(20);
		System.out.println(node2.data); // 20
		System.out.println(node2); // Address/reference of node2
		
		node1.next = node2; // node1 and node2 are linked
		System.out.println(node1.next); // Same address/reference as node2
		System.out.println(node1.next.data); // 20
		
		// Printing Linked List
		print(node1);
		
		// Take Linked List Input
		Node<Integer> head = takeInput();
		print(head);
		
		// Insert Node
		head = insert(head, 80, 3);
		head = insert(head, 50, 0);
		print(head);
		
		// Delete Node
		

	}

}
