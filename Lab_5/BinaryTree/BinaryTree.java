/* BinaryTree.BinaryTree.java */
//    // *** Fields ***


// BinaryTree.BinaryTree class; stores a binary tree.
//
// CONSTRUCTION: with (a) no parameters or (b) an object to
//    be placed in the root of a one-element tree.
//
//  Author: Mark Allen Weiss
// *******************PUBLIC OPERATIONS**********************
// Various tree traversals, size, height, isEmpty, makeEmpty.
// Also, the following tricky method:
// void merge( Object root, BinaryTree.BinaryTree t1, BinaryTree.BinaryTree t2 )
//                        --> Construct a new tree
// *******************ERRORS*********************************
// Error message printed for illegal merges.
public class BinaryTree<AnyType> {
    private BinaryNode<AnyType> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(AnyType rootItem) {
        root = new BinaryNode<>(rootItem, null, null);
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BinaryNode<AnyType> getRoot() {
        return root;
    }

    /**
     * Returns the number of nodes in the tree. Uses a recursive helper that recurs
     * down the tree and counts the nodes.
     */
    public int size() {
        return BinaryNode.size(root);
    }

    /**
     * Returns the height (max root-to-leaf depth) of the tree. Uses a recursive
     * helper that recurs down to find the height (max depth).
     */
    public int height() {
        // To be implemented
        return BinaryNode.height(root);
    }

    public void printPreOrder() {
        if (root != null)
            root.printPreOrder();
    }

    public void printInOrder() {
        if (root != null)
            root.printInOrder();
    }

    public void printPostOrder() {
        if (root != null)
            root.printPostOrder();
    }

    public void isBalanced() {
        if (root != null)
            root.isBalanced(root);
    }

    public void findDepth() {
        root.findDepth(root);
    }

    public void isPerfect() {
        root.isPerfect(root);
    }

    /**
     * Merge routine for BinaryTree.BinaryTree class. Forms a new tree from rootItem, t1 and
     * t2. Does not allow t1 and t2 to be the same. Correctly handles other aliasing
     * conditions.
     */
    public void merge(AnyType rootItem, BinaryTree<AnyType> t1, BinaryTree<AnyType> t2) {
        if (t1.root == t2.root && t1.root != null) {
            System.err.println("leftTree==rightTree; merge aborted");
            return;
        }

        // Allocate new node
        root = new BinaryNode<>(rootItem, t1.root, t2.root);

        // Ensure that every node is in just one tree!
        if (this != t1)
            t1.root = null;
        if (this != t2)
            t2.root = null;
    }

    static public void main(String[] args) {

        test1();
        test2();
        test3();
    }

    private static void test1() {
        BinaryTree<Integer> t4 = new BinaryTree<>(4);
        BinaryTree<Integer> t5 = new BinaryTree<>(5);
        BinaryTree<Integer> t6 = new BinaryTree<>(6);
        BinaryTree<Integer> t1 = new BinaryTree<>();
        BinaryTree<Integer> t2 = new BinaryTree<>();
        BinaryTree<Integer> t3 = new BinaryTree<>();
        BinaryTree<Integer> temp = new BinaryTree<>();

        t2.merge(2, t4, t5);
        t3.merge(3, t6, temp);
        t1.merge(1, t2, t3);

        System.out.println("t1 should be a tree with 6 nodes; t2 is empty");
        System.out.println("----------------");
        System.out.println("t1 : Pre Order");
        t1.printPreOrder();
        System.out.println("----------------");
        System.out.println("t1 : In Order");
        t1.printInOrder();
        System.out.println("----------------");
        System.out.println("t1 : Post Order");
        t1.printPostOrder();
        System.out.println("----------------");
        System.out.println("t1 size: " + t1.size());
        System.out.println("t1 height: " + t1.height());
        t1.isBalanced();
        t1.isPerfect();

    }

    // create a tree with 7 nodes and minimum possible height
    private static void test2() {
        // Your code

        System.out.println("Test 2");
        BinaryTree<Integer> t4 = new BinaryTree<>(4);
        BinaryTree<Integer> t5 = new BinaryTree<>(5);
        BinaryTree<Integer> t6 = new BinaryTree<>(6);
        BinaryTree<Integer> t7 = new BinaryTree<>(7);
        BinaryTree<Integer> t1 = new BinaryTree<>();
        BinaryTree<Integer> t2 = new BinaryTree<>();
        BinaryTree<Integer> t3 = new BinaryTree<>();

        t2.merge(2, t4, t5);
        t3.merge(3, t6, t7);
        t1.merge(1, t2, t3);

        System.out.println("Test 2 generates a tree with 7 nodes (including root) with minimal height");
        System.out.println("----------------");
        System.out.println("t1 : Pre Order");
        t1.printPreOrder();
        System.out.println("----------------");
        System.out.println("t1 : In Order");
        t1.printInOrder();
        System.out.println("----------------");
        System.out.println("t1 : Post Order");
        t1.printPostOrder();
        System.out.println("----------------");
        System.out.println("t1 size: " + t1.size());
        System.out.println("t1 height: " + t1.height());
        t1.isBalanced();
        t1.isPerfect();

    }

    // create a tree with 7 nodes and maximum possible height
    private static void test3() {
        // Your code


        System.out.println("Test 3");

        BinaryTree<Integer> t7 = new BinaryTree<>(7);
        BinaryTree<Integer> t6 = new BinaryTree<>();
        t6.merge(6, new BinaryTree<>(), t7);
        BinaryTree<Integer> t5 = new BinaryTree<>();
        t5.merge(5, new BinaryTree<>(), t6);
        BinaryTree<Integer> t4 = new BinaryTree<>();
        t4.merge(4, new BinaryTree<>(), t5);
        BinaryTree<Integer> t3 = new BinaryTree<>();
        t3.merge(3, new BinaryTree<>(), t4);
        BinaryTree<Integer> t2 = new BinaryTree<>();
        t2.merge(2, new BinaryTree<>(), t3);
        BinaryTree<Integer> t1 = new BinaryTree<>();
        t1.merge(1, new BinaryTree<>(), t2);

        System.out.println("Test 3 generates a tree with 7 nodes (including root) with Maximal height");
        System.out.println("----------------");
        System.out.println("t1 : Pre Order");
        t1.printPreOrder();
        System.out.println("----------------");
        System.out.println("t1 : In Order");
        t1.printInOrder();
        System.out.println("----------------");
        System.out.println("t1 : Post Order");
        t1.printPostOrder();
        System.out.println("----------------");
        System.out.println("t1 size: " + t1.size());
        System.out.println("t1 height: " + t1.height());
        t1.isBalanced();
        t1.isPerfect();

    }
}