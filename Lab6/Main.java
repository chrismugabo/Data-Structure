// Node class for BST
class Node {
    int key;
    Node leftChild, rightChild;

    public Node(int key) {
        this.key = key;
        leftChild = rightChild = null;
    }
}

// BinarySearchTree class
class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Search for a key
    public Node search(int key) {
        return searchRec(root, key);
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (key < root.key)
            return searchRec(root.leftChild, key);
        else
            return searchRec(root.rightChild, key);
    }

    // Insert a key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.leftChild = insertRec(root.leftChild, key);
        else if (key > root.key)
            root.rightChild = insertRec(root.rightChild, key);
        return root;
    }

    // Delete a key
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.leftChild = deleteRec(root.leftChild, key);
        else if (key > root.key)
            root.rightChild = deleteRec(root.rightChild, key);
        else {
            // Node with one child or no child
            if (root.leftChild == null)
                return root.rightChild;
            else if (root.rightChild == null)
                return root.leftChild;
            // Node with two children: Get the inorder successor
            root.key = minValue(root.rightChild);
            root.rightChild = deleteRec(root.rightChild, root.key);
        }
        return root;
    }

    // Helper function to find the minimum value in a subtree
    private int minValue(Node root) {
        int minVal = root.key;
        while (root.leftChild != null) {
            minVal = root.leftChild.key;
            root = root.leftChild;
        }
        return minVal;
    }

    // Helper function to print the tree (in-order traversal)
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.leftChild);
            System.out.print(root.key + " ");
            inOrderRec(root.rightChild);
        }
    }
}

// Main class to test the BST
public class Main {
    public static void main(String[] args) {
        // Task 1: Create a BST and perform operations
        System.out.println("Task 1:");
        BinarySearchTree bst1 = new BinarySearchTree();
        int[] keys1 = {23, 41, 75, 43, 81, 12, 34, 99, 101, 106, 27};
        for (int key : keys1) {
            bst1.insert(key);
        }

        System.out.println("In-order traversal of the BST (initial):");
        bst1.inOrder();

        // Demo search
        System.out.println("Search for 43: " + (bst1.search(43) != null ? "Found" : "Not Found"));
            


        // Demo insert
        System.out.println("Inserting 50...");
        bst1.insert(50);
        System.out.println("In-order traversal after inserting 50:");
        bst1.inOrder();

        // Demo delete
        System.out.println("Deleting 43...");
        bst1.delete(43);
        System.out.println("In-order traversal after deleting 43:");
        bst1.inOrder();

        // Task 2: Insert and delete sequence
        System.out.println("\nTask 2:");
        BinarySearchTree bst2 = new BinarySearchTree();
        int[] keys2 = {15, 23, 20, 10, 13, 6, 18, 35, 9, 24};
        for (int key : keys2) {
            bst2.insert(key);
        }

        System.out.println("In-order traversal after inserting keys:");
        bst2.inOrder();

        // Delete 6, 15, 20
        System.out.println("Deleting 6...");
        bst2.delete(6);
        System.out.println("In-order traversal after deleting 6:");
        bst2.inOrder();

        System.out.println("Deleting 15...");
        bst2.delete(15);
        System.out.println("In-order traversal after deleting 15:");
        bst2.inOrder();

        System.out.println("Deleting 20...");
        bst2.delete(20);
        System.out.println("In-order traversal after deleting 20:");
        bst2.inOrder();
    }
}

