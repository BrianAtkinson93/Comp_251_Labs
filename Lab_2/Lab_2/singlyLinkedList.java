package Lab_2;

public class singlyLinkedList {

	// Represent a node of the singly linked list

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	// The addNode() function adds a new node to the list
	public void addNode(int data) {
		// Create a new node
		Node newNode = new Node(data);

		// Checks if the list is empty
		if (head == null) {
			// If list is empty, both head and tail will point to new node
			head = newNode;
			tail = newNode;
		} else {
			// newNode will be added after tail such that tail's next will point to newNode
			tail.next = newNode;
			// newNode will become new tail of the list
			tail = newNode;
		}
	}

	// The swap() function will swap (parameters nodeOne and nodeTwo) the given two
	// nodes
	public void swap(int nodeOne, int nodeTwo) {
		Node prevNode1 = null, prevNode2 = null, node1 = head, node2 = head;

		// Checks if list is empty
		if (head == null) {
			return;
		}

		// If n1 and n2 are equal, then list will remain the same
		if (nodeOne == nodeTwo)
			return;

		// Search for nodeOne
		while (node1 != null && node1.data != nodeOne) {
			prevNode1 = node1;
			node1 = node1.next;
		}

		// Search for nodeTwo
		while (node2 != null && node2.data != nodeTwo) {
			prevNode2 = node2;
			node2 = node2.next;
		}

		if (node1 != null && node2 != null) {

			// If previous node to nodeOne is not null then, it will point to nodeTwo
			if (prevNode1 != null)
				prevNode1.next = node2;
			else
				head = node2;

			// If previous node to nodeTwo is not null then, it will point to nodeOne
			if (prevNode2 != null)
				prevNode2.next = node1;
			else
				head = node1;
			
			
			// Swaps the next nodes of node1 and node2
			Node temp = node1.next;
			node1.next = node2.next;
			node2.next = temp;
		} else {
			System.out.println("Swapping is not possible");
		}
	}

	// display() will display all the nodes present in the list
	public void display() {
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while (current != null) {
			// Prints each node by incrementing pointer
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}