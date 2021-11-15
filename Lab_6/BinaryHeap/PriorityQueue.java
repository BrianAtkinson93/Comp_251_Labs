import java.util.*;

/**
 * PriorityQueue class implemented via the binary heap.
 */
public class PriorityQueue<AnyType extends Comparable<? super AnyType>> {

    private static int INITSIZE = 100;

    private int currentSize;   // Number of elements in heap
    private AnyType[] array; // The heap array


    /**
     * Construct an empty PriorityQueue.
     */
    public PriorityQueue() {
        currentSize = 0;
        array = (AnyType[]) new Comparable[INITSIZE + 1];
    }


    /**
     * Inserts an item to this PriorityQueue.
     *
     * @param x any object.
     * @return true.
     */
    public boolean push(AnyType x) {
        if (currentSize + 1 == array.length)
            expandArray();

        // Percolate up
        int hole = ++currentSize;
        array[0] = x;

        for (; x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;

        return true;
    }

    /**
     * isEmpty() indicates whether the heap is empty.
     *
     * @return true if the list is empty, false otherwise.
     **/

    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Returns the number of items in this PriorityQueue.
     *
     * @return the number of items in this PriorityQueue.
     */
    public int size() {
        return currentSize;
    }

    /**
     * Make this PriorityQueue empty.
     */
    public void clear() {
        currentSize = 0;
    }

    /**
     * Returns the smallest item in the priority queue.
     *
     * @return the smallest item.
     * @throws NoSuchElementException if empty.
     */
    public AnyType top() {
        if (isEmpty())
            throw new NoSuchElementException();
        return array[1];
    }

    /**
     * Removes the smallest item in the priority queue.
     *
     * @return the smallest item.
     * @throws NoSuchElementException if empty.
     */
    public AnyType pop() {
        AnyType minItem = top();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }


    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    public void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }


    /**
     * Internal method to percolate down in the heap.
     *
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize &&
                    array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

    /**
     * expandArray(): internal method to extend array.
     * creates a new array with larger size (twice)
     */
    private void expandArray() {
        AnyType[] newArray;

        newArray = (AnyType[]) new Comparable[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }


    public static void main(String[] args) {
        // Below we are initializing the PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // Here I create a list to add the remaining items from the queue in order
        List<Integer> outputList = new ArrayList<>();


        // Assigning the array of integers to finalArray[]
        int[] finalArray = {5, 3, 9, 7, 2, 4, 6, 1, 8};
        // Adding the integers to the PriorityQueue in order given
        System.out.println("Below I am adding the items into an array in order received : ");
        for (int j : finalArray) {
            queue.push(j);
        }


        // Printing out the queue after adding the integers in order given
        System.out.println(Arrays.toString(finalArray));


        System.out.println("\nBelow I start to build the heap : ");
        // Building the Heap ( This means putting the integers in order (smallest to largest) in this case
        queue.buildHeap();
        // Outputting the first three elements of the queue
        System.out.println("First pop() : " + queue.pop() + "\nSecond pop() : " + queue.pop() + "\nThird pop() : " + queue.pop());


        // While the queue is NOT empty, pop each element
        while (!(queue.isEmpty())) {
            outputList.add(queue.pop());
        }


        // Outputting the remainder of the queue as a list
        System.out.println("\nThis is what is left of the queue : " + outputList);

    }
}
