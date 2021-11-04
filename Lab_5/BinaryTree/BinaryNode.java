//BinaryNode class; stores a node in a tree.

//
//CONSTRUCTION: with (a) no parameters, or (b) an Object,
//  or (c) an Object, left child, and right child.
//
//*******************PUBLIC OPERATIONS**********************
//int size( )            --> Return size of subtree at node
//int height( )          --> Return height of subtree at node
//void printPostOrder( ) --> Print a postorder tree traversal
//void printInOrder( )   --> Print an inorder tree traversal
//void printPreOrder( )  --> Print a preorder tree traversal
//BinaryNode duplicate( )--> Return a duplicate tree

/**
 * Binary node class with recursive routines to compute size and height.
 */
class BinaryNode<AnyType> {
    private AnyType item;
    private BinaryNode<AnyType> left;
    private BinaryNode<AnyType> right;

    public BinaryNode() {
        this(null, null, null);
    }

    public BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
        item = theElement;
        left = lt;
        right = rt;
    }

    // access to fields
    public AnyType getElement() {
        return item;
    }

    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    public BinaryNode<AnyType> getRight() {
        return right;
    }

    // change fields
    public void setElement(AnyType x) {
        item = x;
    }

    public void setLeft(BinaryNode<AnyType> t) {
        left = t;
    }

    public void setRight(BinaryNode<AnyType> t) {
        right = t;
    }

    /**
     * Return the size of the binary tree rooted at t. Note that the method is
     * static, so we can call even before any object created.
     */
    public static <AnyType> int size(BinaryNode<AnyType> t) {
        if (t == null)
            return 0;
        else
            return 1 + size(t.left) + size(t.right);
    }

    /**
     * Return the height of the binary tree rooted at t.
     */
    public static <AnyType> int height(BinaryNode<AnyType> t) {
        // To be implemented
        if (t == null)
            return 0;
        else
            return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
    }

    // Print tree rooted at current node using preorder traversal.
    public void printPreOrder() {
        System.out.println(item);
        if (left != null)
            left.printPreOrder();
        if (right != null)
            right.printPreOrder();
    }

    // Print tree rooted at current node using postorder traversal.
    public void printPostOrder() {
        if (left != null)
            left.printPostOrder();
        if (right != null)
            right.printPostOrder();
        System.out.println(item);
    }

    // Print tree rooted at current node using inorder traversal.
    public void printInOrder() {
        if (left != null)
            left.printInOrder(); // Left
        System.out.println(item); // Node
        if (right != null)
            right.printInOrder(); // Right
    }

    // this function specifically calls the recursive function and then
    // returns a boolean for the main balanced function
    public boolean isBalancedcalc(BinaryNode<AnyType> t) {
        if (t == null)
            return true;
        if (isBalancedRec(t) == -1)
            return false;
        return true;
    }

    // this is the main balanced function which is called from the main
    // once calculating if the tree is balanced or not prints to the user
    // the result.
    public void isBalanced(BinaryNode<AnyType> t) {
        if (isBalancedcalc(t) == true)
            System.out.println("Tree is balanced!");
        if (isBalancedcalc(t) == false)
            System.out.println("Tree is not balanced");
    }

    // this function is recursively checks the height of both
    // left and right branches. A binary tree is considered "balanced"
    // as long as the branches are within +/- 1 of eachother.
    public int isBalancedRec(BinaryNode<AnyType> t) {
        if (t == null)
            return 0;

        if (height(left) == -1 || height(right) == -1)
            return -1;
        if (Math.abs(height(left) - height(right)) > 1) {
            return -1;
        }
        return Math.max(height(left), height(right)) + 1;
    }

    // This method was put in place with to check the depth of the tree
    // This depth variable is then used in the isPerfectRec function so we
    // can check, if each branch of the tree has the same depth/same leafs
    public int findDepth(BinaryNode<AnyType> t) {
        int d = 0;
        while (t != null) {
            d++;
            t = t.getLeft();
        }
        return d;
    }

    // This function is specifically to check the right and left branchs to verify that
    // they are perfect of not. In order for a binary tree to be perfect they must have
    // the exactly the same left and right side depth and width. So it checks each level
    // and then if satisfied it will increment to the next until one or both sides returns null.
    public boolean isPerfectRec(BinaryNode<AnyType> t, int d, int level) {
        // Empty trees are perfect
        if (t == null) {
            return true;
        }
        // if leaf node, then its depth must the same as depth of all other leaves
        if (t.left == null && t.right == null)
            return (d == level + 1);
        // if internal node and one child is empty
        if (t.left == null || t.right == null) {
            return false;
        }

        // left and right subrees must be perfect
        return isPerfectRec(t.left, d, level + 1) && isPerfectRec(t.right, d, level + 1);
    }

    // This is the main perfect function which is called from the main program
    // which will call depth and isperfectrec for the specific tree in question.
    // then prints out to the user if the tree is perfect or not.
    public void isPerfect(BinaryNode<AnyType> t) {
        int d = findDepth(t);
        if (isPerfectRec(t, d, 0) == true) {
            System.out.println("Tree is perfect! :D");
        }
        if (isPerfectRec(t, d, 0) == false) {
            System.out.println("Tree is not perfect :(");
        }

    }

    /**
     * Return a reference to a node that is the root of a duplicate of the binary
     * tree rooted at the current node. In other words, create a copy of the tree
     * rooted at the current node.
     */
    public BinaryNode<AnyType> duplicate() {
        BinaryNode<AnyType> root = new BinaryNode<AnyType>(item, null, null);

        if (left != null) // If there's a left subtree
            root.left = left.duplicate(); // Duplicate; attach
        if (right != null) // If there's a right subtree
            root.right = right.duplicate(); // Duplicate; attach
        return root; // Return resulting tree
    }

}
