import java.util.*;
/*
https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 */
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

class Solution {
    static TreeMap<Integer, List<Node>> map = new TreeMap<>();

    /*
    
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static void traverse(Integer level, Node root) {
        if (root == null) {
            return;
        }
        List<Node> list = map.get(level);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(root);
        map.put(level, list);
        if (root.left != null) {
            traverse(level + 1, root.left);
        }
        if (root.right != null) {
            traverse(level + 1, root.right);
        }

    }

    public static void levelOrder(Node root) {
        traverse(0, root);
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Node> value = entry.getValue();

            for (Node n : value) {
                System.out.printf("%d ", n.data);
            }
        }

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
        levelOrder(root);
    }
}