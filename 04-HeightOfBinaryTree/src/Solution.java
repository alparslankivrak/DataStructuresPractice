import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Solution {

    /*
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        int height = 0;
        if (root == null) {
            return height;
        }
        int leftHeight = 0, rightHeight = 0;
        if (root.left != null) {
            leftHeight = height(root.left) + 1;
        }
        if (root.right != null) {
            rightHeight = height(root.right) + 1;
        }
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}