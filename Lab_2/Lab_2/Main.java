package Lab_2;

public class Main {

	public static void main(String[] args) {

// ------------------------PART ONE------------------------
		// Here I create my single list
		singlyLinkedList singleList = new singlyLinkedList();

		// Add nodes to the list
		singleList.addNode(1);
		singleList.addNode(2);
//		singleList.addNode(3);
//		singleList.addNode(4);

		System.out.println("-----PART ONE-----");
		System.out.println("Original list: ");
		singleList.display();

		// Swaps node 1 with node 2
		singleList.swap(1, 2);

		System.out.println("List after swapping nodes: ");
		singleList.display();
		System.out.println("");

// ------------------------PART TWO------------------------

		System.out.println("-----PART TWO-----");
		// Here I create the two lists and populate them with random numbers
		doublyLinkedList<Integer> doubleListOne = new doublyLinkedList<Integer>();

		doubleListOne.addLast(1);
		doubleListOne.addLast(2);
		doubleListOne.addLast(3);
		doubleListOne.addLast(4);
		doubleListOne.addLast(5);

		System.out.println("Original List One :");

		doublyLinkedList.Node<Integer> temp1 = doubleListOne.head.next;

		// Prints each node by incrementing pointer
		while (temp1 != doubleListOne.tail) {

			System.out.print(temp1.getElement() + " ");

			temp1 = temp1.next;

		}

		System.out.println("");

		System.out.println("Original List Two :");

		doublyLinkedList<Integer> doubleListTwo = new doublyLinkedList<Integer>();

		doubleListTwo.addLast(11);
		doubleListTwo.addLast(22);
		doubleListTwo.addLast(33);
		doubleListTwo.addLast(44);
		doubleListTwo.addLast(55);

		doublyLinkedList.Node<Integer> temp2 = doubleListTwo.head.next;

		// Prints each node by incrementing pointer
		while (temp2 != doubleListTwo.tail) {

			System.out.print(temp2.getElement() + " ");

			temp2 = temp2.next;

		}

		System.out.println("");
		System.out.println("");

		// here I create a new list (list 3) which will be the concatenated list
		doublyLinkedList<Integer> doubleListThree = doublyLinkedList.concatenateLists(doubleListOne, doubleListTwo);

		// displaying concatenated list
		System.out.println("Concatenated list Three : ");

		// looping through doubleListThree and printing elements
		doublyLinkedList.Node<Integer> temp3 = doubleListThree.head.next;

		// Prints each node by incrementing pointer
		while (temp3 != doubleListThree.tail) {

			System.out.print(temp3.getElement() + " ");

			temp3 = temp3.next;

		}

	}
}
