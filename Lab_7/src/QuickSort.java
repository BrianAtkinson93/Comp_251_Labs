
public class QuickSort {


    /**
     * Quicksort algorithm.
     *
     * @param a an array of Comparable items.
     */
    public static void quicksort(Comparable[] a) {
        quicksort(a, 0, a.length - 1);
    }

    /**
     * Method to swap to elements in an array.
     *
     * @param a      an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static final void swapReferences(Object[] a, int index1, int index2) {
        Object tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }


    public static void printStatement(Comparable[] a){
        for(Comparable b : a){
            System.out.print(b + " ");
        }
        System.out.println("\n");
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     *
     * @param a    an array of Comparable items.
     * @param low  the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     */
    private static void quicksort(Comparable[] a, int first, int last) {
        if (first < last) {
            int pIndex = partition(a, first, last);
            printStatement(a);
            quicksort(a, first, pIndex - 1);    // Sort small elements
            quicksort(a, pIndex + 1, last);   // Sort large elements
        }
    }

    private static int partition(Comparable[] a, int first, int last) {
        // your solution here
        // This function takes the last element as pivot, places the pivot
        // element at its correct position in sorted array, and places all
        // smaller to left and greater to right
        Comparable pivot = a[last];

        int i = (first - 1);

        for (int j = first; j < last; ++j) {
            // the compareTo will return -1 if it is less than
            // so i set it <= 0 as anything => 0 need go on the right
            if (a[j].compareTo(pivot) <= 0) {
                ++i;
                swapReferences(a, i, j);
            }
        }

        swapReferences(a, i + 1, last);
        return i + 1;
    }

    public static void main(String[] args) {
        Integer[] items;
        items = new Integer[20];
        for (int i = 0; i < 20; i++) {
            items[i] = new Integer(20 - i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
        quicksort(items);
        for (int i = 0; i < 20; i++) {
            System.out.print(items[i] + " ");
        }
    }

}