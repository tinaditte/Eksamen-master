package Graphs_Trees.BinaryTree;

public class BinaryTree {

    Node root;

    //new val lower than current node --> left child
    //new node greater than current --> right child
    //current node = null --> reached leaf node --> insert new node in that position.

    private Node addRecursive(Node current, int value){
        if (current == null){
            return new Node(value);
        }
        if (value < current.value){
            current.left = addRecursive(current.left, value);
        }else if (value > current.value){
            current.right = addRecursive(current.right, value);
        }else {
            //Value already exists
            return current;
        }
        return current;
    }

    public void add(int value){
        //Start recursion from root
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value){
        if (current == null){
            return false;
        }
        if (value == current.value){
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

}
