package DataStructure.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static Node root;

    // DFS scenario, first left node, then root, then right node
    public void inOrderTraversal(Node node){
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.data+" ");
        inOrderTraversal(node.right);
    }

    // DFS scenario, first root, then left node, then right node
    public void preOrderTraversal(Node node){
        if(node == null)
            return;
        System.out.print(node.data+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // DFS scenario, first left node, then right node, then root
    public void postOrderTraversal(Node node){
        if(node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+" ");
    }

    //BFS scenario, roots at the same level will be traversed then will go to the next depth and print root
    public void levelOrderTraversal(Node node){
        if(node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (queue.isEmpty() != true){
            Node node1 = queue.remove();
            System.out.print(node1.data+" ");

            if(node1.left != null)
                queue.add(node1.left);
            if(node1.right != null)
                queue.add(node1.right);
        }

    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        root = n1;
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;


        BinaryTree tree = new BinaryTree();
        System.out.println("DFS Algos:");
        System.out.println("Inorder Traversal:");
        tree.inOrderTraversal(root);
        System.out.println();
        System.out.println("PreOrder Traversal:");
        tree.preOrderTraversal(root);
        System.out.println();
        System.out.println("PostOrder Traversal:");
        tree.postOrderTraversal(root);
        System.out.println();
        System.out.println("BFS Algos:");
        System.out.println("LevelOrder Traversal:");
        tree.levelOrderTraversal(root);
        System.out.println();

    }

}
