@SuppressWarnings("hiding")
public class doublyLinkedList<Integer> { // Type restricted to Integer

    static class Node<Integer> {

        private Integer element; // reference to the element stored at this node

        private Node<Integer> prev; // reference to the previous node in the list

        Node<Integer> next; // reference to the next node in the list

        public Node(Integer e, Node<Integer> p, Node<Integer> n) {

            element = e;

            prev = p;

            next = n;

        }

        // Getters and Setters

        public Integer getElement() {
            return element;
        }

        public Node<Integer> getPrev() {
            return prev;
        }

        public Node<Integer> getNext() {
            return next;
        }

        public void setPrev(Node<Integer> prev) {
            this.prev = prev;
        }

        public void setNext(Node<Integer> next) {
            this.next = next;
        }

    }

    // instance variables of the DoublyLinkedList

    Node<Integer> head;

    Node<Integer> tail;

    private int size = 0;

    public doublyLinkedList() {

        head = new Node<>(null, null, null); // create head ( element, previous, next )

        tail = new Node<>(null, head, null); // tail is preceded by ( element, previous, next )

        head.setNext(tail); // head is followed by tail ( head <-> tail )

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer first() {

        if (isEmpty())
            return null;

        return head.getNext().getElement(); // first element is beyond head

    }

    public Integer last() {

        if (isEmpty())
            return null;

        return tail.getPrev().getElement(); // last element is before tail

    }

    // public update methods

    public void addFirst(Integer i) {

        addBetween(i, head, head.getNext()); // place just after the head

    }

    public void addLast(Integer i) {

        addBetween(i, tail.getPrev(), tail); // place just before the tail
    }

    public Integer removeFirst() {

        if (isEmpty())

            return null; // nothing to remove

        return remove(head.getNext()); // first element is beyond head

    }

    public Integer removeLast() {

        if (isEmpty())

            return null; // nothing to remove

        return remove(tail.getPrev()); // last element is before tail

    }

    // private update methods

    private void addBetween(Integer i, Node<Integer> predecessor, Node<Integer> successor) {

        // create and link a new node

        Node<Integer> newest = new Node<>(i, predecessor, successor);

        predecessor.setNext(newest);

        successor.setPrev(newest);

        size++;

    }

    private Integer remove(Node<Integer> node) {

        Node<Integer> predecessor = node.getPrev();

        Node<Integer> successor = node.getNext();

        predecessor.setNext(successor);

        successor.setPrev(predecessor);

        size--;

        return node.getElement();

    }

// --------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------

    // Below we begin the concatenation of the two lists
    // here we have set the paramters as list L and list M.
    // We start by creating the new list, then getting the first
    // node from list L.
    // 		While the temp node is not equal to the last node we
    // continue to add each to the end of the new list L.
    // One list L is finshed we get each node from the list M.
    // we add each node to the new list as we did with list L continuing
    // to add the nodes to the LAST position in the no doubly linked list.
    public static <Integer> doublyLinkedList<Integer> concatenateLists(

            doublyLinkedList<Integer> L, doublyLinkedList<Integer> M) {

        // creating a new list

        doublyLinkedList<Integer> newList = new doublyLinkedList<>();

        // getting the first node of L

        Node<Integer> temp = L.head.next;

        // looping until the end of first list

        while (temp != L.tail) {

            // appending element to the end of newList

            newList.addLast(temp.element);

            temp = temp.next;

        }

        // getting the first node of M

        temp = M.head.next;

        // looping until the end of second list

        while (temp != M.tail) {

            // appending element to the end of newList

            newList.addLast(temp.element);

            temp = temp.next;

        }

        // returning newList
        return newList;

    }

    public void display() {
        // Node current will point to head
        Node<Integer> current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            // Prints each node by incrementing pointer
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
}