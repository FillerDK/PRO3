package opgaver.opg2;

import udleveret.bst.BST;

import java.util.Arrays;

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

        // inorderList()
        System.out.println("InorderList: " + bst.inorderList());

        // height()
        System.out.println("Height: " + bst.height());

        // findMax()
        System.out.println("Max: " + bst.findMax());

        // findMin()
        System.out.println("Min: " + bst.findMin());

        // leafCount()
        System.out.println("LeafCount: " + bst.leafCount());

        // sum()
        System.out.println("Sum: " + bst.sum());
    }
}
