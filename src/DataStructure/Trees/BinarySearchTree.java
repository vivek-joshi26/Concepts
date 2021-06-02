package DataStructure.Trees;

public class BinarySearchTree {
    int data;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        left = right = null;
    }

    //Recursive approach to find a data in BST
    public BinarySearchTree Find(BinarySearchTree tree, int data){
        if( tree == null)
            return null;

        if( data < tree.data)
           return Find(tree.left,data);

        else if (data > tree.data)
            return Find(tree.right,data);

        return tree;
    }

    //Iterative approach to find a data in BST
    public BinarySearchTree FindIterative(BinarySearchTree tree, int data){
        if(tree == null)
            return null;
        while (tree != null){
            if( data == tree.data)
                return tree;
            else if( data < tree.data)
                tree = tree.left;
            else if (data > tree.data) {
                tree = tree.right;
            }
        }
        return null;
    }

    // Finding minimum data from a BST using recursive
    public BinarySearchTree FindMin(BinarySearchTree tree){
        if(tree == null)
            return null;
        if( tree.left == null)
            return tree;
        return FindMin(tree.left);
    }

    // Finding minimum data from a BST using Iterative
    public BinarySearchTree FindMinIterative(BinarySearchTree tree){
        if(tree == null)
            return null;
        while (tree.left != null){
            tree = tree.left;
        }
        return tree;
    }

    //Finding max data using recursion
    public BinarySearchTree FindMax(BinarySearchTree tree){
        if (tree == null)
            return null;
        if( tree.right == null)
            return tree;
        return FindMax(tree.right);
    }

    //Finding max data using Iteration
    public BinarySearchTree FindMaxIteration(BinarySearchTree tree){
        if( tree == null)
            return null;
        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    //insert a data in BST and return the tree root
    public BinarySearchTree insert(BinarySearchTree root, int data){
        if( root == null){
            BinarySearchTree node = new BinarySearchTree(data);
            return node;
        }
       if ( data < root.data)
           root.left = insert(root.left,data);
       else if(data > root.data)
           root.right = insert(root.right,data);
       return root;
    }

    //delete a data from BST
    //3 scenarios can be there
    //1- no child is there,2- 1 child is present, just make the child as root, 3- both childs are present, then search min value from right node
    public BinarySearchTree delete(BinarySearchTree root,int data){
        if(root == null)
            return root;
        if( data < root.data)
            return delete(root.left,data);
        else if(data > root.data)
            return delete(root.right,data);
        else {
            //when no child or only 1 child is present
            if(root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            //when the node to be deleted has 2 childs, then find min value from right subchild and replace both
            root.data = minValue(root.right);
            delete(root.right,root.data);
            }

        return root;
    }

    public int minValue(BinarySearchTree tree){
       /* int minv = tree.data;
        while (tree.left != null){
            tree = tree.left;
            minv = tree.data;
        }
        return minv;
        */
        if(tree.left == null)
            return tree.data;
        return minValue(tree.left);
    }
}
