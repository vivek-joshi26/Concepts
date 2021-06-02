package DataStructure.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public List<Integer> inorderTraversal2(Node root) {

        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;

    }

    public void helper(Node root, List<Integer> result){

        if(root != null){
            if(root.left != null){
                helper(root.left,result);
            }
            result.add(root.data);
            if (root.right != null){
                helper(root.right,result);
            }
        }
    }

    public static void main(String[] args) {
        Test obj1 = new Test();
        Node n1 = new Node(1);
        //Node n2 = new Node();
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        //Node n5 = new Node(5);

        n1.right = n3;
        n3.left = n4;
        //n2.right = n5;
        List<Integer> a = new ArrayList<>();
        a = obj1.inorderTraversal2(n1);

        for (int n :a
             ) {
            System.out.print(n+ " " );

        }
        //System.out.println(a);
    }
}
