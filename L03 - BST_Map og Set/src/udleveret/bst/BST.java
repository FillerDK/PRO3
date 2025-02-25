package udleveret.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * BST is a binary search tree.
 * Note: Equal elements are not allowed in the tree.
 * Note: The methods add() and remove does not re-balance the tree.
 */

public class BST<E extends Comparable<E>> {
    private TreeNode root;
    private int size;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.size = 0;
        this.root = null;
    }


    /**
     * Insert element e into the binary tree
     * Return true if the element is inserted successfully
     * Return false if the element is found in the tree before insertion.
     */
    public boolean insert(E e) {
        // Locate the node with the element e and its parent node.
        NodePair pair = locateNodeAndParent(e);
        boolean inserted = false;
        if (pair.current == null) {
            if (root == null) {
                root = new TreeNode(e); // Create a new root
            } else {
                TreeNode parent = pair.parent;
                // Create a new node and attach it to the parent node.
                if (e.compareTo(parent.element) < 0) {
                    parent.left = new TreeNode(e);
                } else {
                    parent.right = new TreeNode(e);
                }
            }
            inserted = true;
            size++;
        }
        return inserted; // Element inserted successfully
    }

    // Return a (current, parent)-pair consisting of
    // the node containing the element e and this node's parent.
    // Return value:
    //   current != null and parent != null: current contains e and parent is the parent to current
    //   current != null and parent == null: current is the root containing e
    //   current == null and parent != null: e is not found
    //         and parent is the node where a node with e would be inserted as child
    //   current == null and parent == null: the three is empty
    private NodePair locateNodeAndParent(E e) {
        boolean found = false;
        TreeNode parent = null;
        TreeNode current = root; // Start from the root
        while (!found && current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                found = true;
            }
        }
        return new NodePair(current, parent);
    }

    private class NodePair {
        private TreeNode current;
        private TreeNode parent;

        public NodePair(TreeNode current, TreeNode parent) {
            this.current = current;
            this.parent = parent;
        }
    }



    /**
     * Returns true if the element is in the tree
     */
    public boolean search(E e) {
        // Locate the node with the element e (and its parent node).
        NodePair pair = locateNodeAndParent(e);
        return pair.current != null;
    }



    /**
     * Inorder traversal from the root
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree
     */
    private void inorder(TreeNode root) {
        if (root.element != null) {
            inorder(root.left);
            System.out.print(root.element + ", ");
            inorder(root.right);
        }
    }


    /**
     * Postorder traversal from the root
     */
    public void postorder() {
        postorder(root);
    }

    /**
     * Postorder traversal from subtree
     */
    public void postorder(TreeNode root) {
        if (root.element != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + ", ");
        }
    }


    /**
     * Preorder traversal from the root
     */
    public void preorder() {
        preorder(root);
    }

    /**
     * Preorder traversal from subtree
     */
    private void preorder(TreeNode root) {
        if (root.element != null) {
            System.out.print(root.element + ", ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    private class TreeNode {
        private E element;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(E e) {
            element = e;
        }
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    private TreeNode getRoot() {
        return root;
    }

    /**
     * Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree
     */
    public boolean delete(E e) {
        // Locate the node with the element e and its parent node.
        NodePair pair = locateNodeAndParent(e);
        boolean found = true;
        if (pair.current == null) { // the element e is not in the tree
            found = false;
        } else {
            TreeNode current = pair.current;
            TreeNode parent = pair.parent; // may be null
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (e.compareTo(parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost(biggest) node in the left subtree of
                // the current node and also its parent
                TreeNode parentOfRightMost = current;
                TreeNode rightMost = current.left;

                if (rightMost.right == null) { // special case: no node to the right of rightMost
                    current.element = rightMost.element;
                    current.left = rightMost.left;
                } else {
                    while (rightMost.right != null) {
                        parentOfRightMost = rightMost;
                        rightMost = rightMost.right; // keep going to the right
                    }
                    // Replace the element in current by the element in rightMost.
                    current.element = rightMost.element;
                    // Eliminate rightmost node.
                    parentOfRightMost.right = rightMost.left;
                }

            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode node) {
        if (node == null) return "";
        return toString(node.left) + " " + node.element + " " + toString(node.right);
    }

    //-------------------------------------------------------------------

    /**
     * Returnerer en List med indholdet af alle
     * knuderne i inorder rækkefølge.
     */
    public List<E> inorderList() {
        return inorderList(root);
    }

    private List<E> inorderList(TreeNode root) {
        List<E> result = new ArrayList<>();

        if (root.left != null) {
            result.addAll(inorderList(root.left));
        }
        if (root.element != null) {
            result.add(root.element);
        }
        if (root.right != null) {
            result.addAll(inorderList(root.right));
        }

        return result;
    }

    /**
     * Returnerer højden på det binære søgetræ
     * (baseret på del-løs og kombiner skabelonen).
     */
    public int height() {
        return height(root);
    }

    private int height(TreeNode root) {
        if (root.element == null) {
            return -1;
        } else {
            int h1 = 0;
            if (root.left != null)
                h1 = height(root.left);
            int h2 = 0;
            if (root.right != null)
                h2 = height(root.right);
            return 1 + (h1 > h2 ? h1 : h2);
        }
    }

    /**
     * Returnerer største element i søgetræet
     */
    public E findMax() {
        if (root.element == null) {
            return null;
        }

        E max = root.element;
        TreeNode current = root.right;

        while (current != null) {
            max = current.element;
            current = current.right;
        }
        return max;
    }

    /**
     * Returnerer det mindste element i søgetræet
     */
    public E findMin() {
        if (root.element == null) {
            return null;
        }

        E min = root.element;
        TreeNode current = root.left;

        while (current != null) {
            min = current.element;
            current = current.left;
        }
        return min;
    }

    /**
     * Returnerer antallet af blade i træet
     */
    public int leafCount() {
        return leafCount(root);
    }

    private int leafCount(TreeNode root) {
        if (root.left == null && root.right == null)
            return 1;
        else {
            int left = 0;
            if (root.left != null) left = leafCount(root.left);
            int right = 0;
            if (root.right != null) right = leafCount(root.right);
            return left + right;
        }
    }

    public int sum() {
        return sum(root);
    }

    private Integer sum(TreeNode root) {
        Integer sum = 0;

        if (root.element != null) {
            sum += (Integer) root.element;
            if (root.left != null) {
                sum += sum(root.left);
            }
            if (root.right != null) {
                sum += sum(root.right);
            }
        }
        return sum;
    }

    //-------------------------------------------------------------------

    /**
     * Fjerner og returnerer det mindste element i soegetraeet.
     */
    public E removeMin() {
        if (root == null) {
            return null;
        }

        TreeNode parent = null;
        TreeNode current = root;

        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        // Hvis roden er mindst
        if (parent == null) {
            root = current.right;
        } else {
            parent.left = current.right;
        }

        size--;
        return current.element;
    }

    /**
     * Fjerner og returnerer det stoerste element i soegetraeet.
     */
    public E removeMax() {
        if (root == null) {
            return null;
        }

        TreeNode parent = null;
        TreeNode current = root;

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        // Hvis roden er mindst
        if (parent == null) {
            root = current.left;
        } else {
            parent.right = current.left;
        }

        size--;
        return current.element;
    }

    /**
     * Returnerer antallet af de elementer i traet der er stoerre end {@code element}.
     */
    public int greaterThanCount(E element) {
        return greaterThanCount(element, root);
    }

    // greaterThanCount helper
    private int greaterThanCount(E element, TreeNode root) {
        if (root.element != null) { // If root element isn't null
            if (root.element.compareTo(element) > 0) { // If bigger than element
                int left = 0;
                if (root.left != null) left = greaterThanCount(element, root.left); // Repeat for left
                int right = 0;
                if (root.right != null) right = greaterThanCount(element, root.right); // Repeat for right
                return left + right + 1;
            } else if (root.element.compareTo(element) < 0) {
                int right = 0;
                if (root.right != null) right = greaterThanCount(element, root.right); // Repeat for right
                return right;
            }
        }
        return 0;
    }

    /**
     * Returnerer alle elementer i traeet der er stoerre end {@code element}.
     */
    public List<E> greaterThan(E element) {
        List<E> greaterThan = new ArrayList<>(); // Create new list
        greaterThan(element, root, greaterThan); // Call greaterThan method
        return greaterThan; // Return list of objects greater than element
    }

    // greatherThan helper
    private void greaterThan(E element, TreeNode root, List<E> gT) {
        if (root.element != null) { // If root element isn't null
            if (root.element.compareTo(element) > 0) { // If bigger than element
                gT.add(root.element); // Add root element
                if (root.left != null) greaterThan(element, root.left, gT); // Repeat for left
                if (root.right != null) greaterThan(element, root.right, gT); // Repeat for right
            } else if (root.element.compareTo(element) < 0) {
                if (root.right != null) greaterThan(element, root.right, gT); // Repeat for right
            }
        }
    }
}
