package datastructureandalgo.nonlinear;

/*
 *
 * @emankamal
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryTreeNode root;
    private int count;

    public BinarySearchTree() {
        root = null ;
    }

    
    public void add(T element) {
        if (root == null) {
            root = new BinaryTreeNode(element);
        } else {
            addTo(root, element);
        }
        count++;
    }

    private void addTo(BinaryTreeNode node, T element) {
        if (element.compareTo(node.element) < 0) {
            // Case 1: Value is less than the current node value
            if (node.left == null) {
                node.left = new BinaryTreeNode(element);
            } else {
                addTo(node.left, element);
            }

        } else {
            // Case 2: Value is equal to or greater than the current value
            if (node.right == null) {
                node.right = new BinaryTreeNode(element);
            } else {
                addTo(node.right, element);
            }
        }
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    public void preOrderTraversal() {
        preOrder(root);
    }

    public void postOrderTraversal() {
        postOrder(root);
    }

    private void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.left);
            node.visit();
            inOrder(node.right);
        }
    }

    private void preOrder(BinaryTreeNode node) {
        if (node != null) {
            node.visit();
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            node.visit();
        }
    }

    public boolean contains(T element){
      return find(element) != null;
    }
    
    public BinaryTreeNode find(T searchedElement) {
        BinaryTreeNode current = root;
        while (current != null) {
            int result = current.element.compareTo(searchedElement);
            if (result > 0) {
                current = current.left;
            } else if (result < 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return current;
    }

    class BinaryTreeNode {

        BinaryTreeNode left;
        BinaryTreeNode right;
        T element;

        BinaryTreeNode(T element) {
            this.element = element;
        }

        private void visit() {
            System.out.print(this.element + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.add(50);
        bst.add(70);
        bst.add(15);
        bst.add(35);
        bst.add(30);
        bst.add(31);
        
        System.out.println("tree contains 50 ?? " + bst.contains(50));
        System.out.println("tree contains 20 ?? " + bst.contains(20));

        System.out.println((bst.find(16) == null) ? "Node not found" : String.valueOf(bst.find(16).element));
        System.out.println((bst.find(35) == null) ? "Node not found" : String.valueOf(bst.find(35).element));
        
        System.out.println("Inorder traversal of binary tree");
        bst.inOrderTraversal();
        System.out.println();
       
        System.out.println("Preorder traversal of binary tree");
        bst.preOrder(bst.root);
        System.out.println();
        
        System.out.println("Postorder traversal of binary tree");
        bst.postOrder(bst.root);
        System.out.println();
    }
}
