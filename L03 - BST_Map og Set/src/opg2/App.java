package opg2;

import udleveret.bst.BST;

public class App {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(45);
        bst.insert(22);
        bst.insert(11);
        bst.insert(77);
        bst.insert(30);
        bst.insert(90);
        bst.insert(15);
        bst.insert(88);
        bst.insert(25);

        System.out.println("Greater than 46: " + bst.greaterThan(46));
        System.out.println("Height of tree: " + bst.height());
        System.out.println("Sum of leaves: " + bst.sumOfLeaves());
        System.out.println("Nodes at level 2: " + bst.countNodesAtHeight(2));
        /*
        while (bst.getSize() > 0) {
            bst.removeMax();
            System.out.println(bst.toString());
        }
         */
    }
}
