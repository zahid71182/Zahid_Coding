// Class representing a single node in the binary tree
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to create a new node
    public Node(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

// Class representing the Binary Tree itself
class BinaryTree {
    Node root;

    // Constructor to initialize an empty tree
    public BinaryTree() {
        this.root = null;
    }

    // 1. IN-ORDER Traversal (Left, Root, Right)
    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);             // Traverse left subtree
        System.out.print(node.data + " "); // Visit root node
        inorder(node.right);            // Traverse right subtree
    }

    // 2. PRE-ORDER Traversal (Root, Left, Right)
    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " "); // Visit root node
        preorder(node.left);            // Traverse left subtree
        preorder(node.right);           // Traverse right subtree
    }

    // 3. POST-ORDER Traversal (Left, Right, Root)
    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);           // Traverse left subtree
        postorder(node.right);          // Traverse right subtree
        System.out.print(node.data + " "); // Visit root node
    }
}

// Main class to build the tree and test traversals
public class TreeImplementation {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Let's construct this sample binary tree manually:
                   1
                 /   \
                2     3
               / \
              4   5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Testing the Tree Traversals
        System.out.print("Pre-order traversal:  ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("In-order traversal:   ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postorder(tree.root);
        System.out.println();
    }
}