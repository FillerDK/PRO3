package opgaver.opg1;

import udleveret.bst.BST;

import javax.swing.tree.TreeNode;

public class App {
    /*
                    45
                   /  \
                22     77
              /    \     \
            11      30    90
             \     /     /
             15  25    88
     */

    public static void main(String[] args) {
        //----------------- Opg 1.1 -----------------
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

        //----------------- Opg 1.2 -----------------
        /*
          Preorder:  45, 22, 11, 15, 30, 25, 77, 90, 88
          Inorder:   11, 15, 22, 25, 30, 45, 77, 88, 90
          Postorder: 15, 11, 25, 30, 22, 88, 90, 77, 45
         */

        //----------------- Opg 1.3 -----------------
        System.out.print("Preorder: ");
        bst.preorder();
        System.out.print("Inorder: ");
        bst.inorder();
        System.out.print("Postorder: ");
        bst.postorder();
    }
}
