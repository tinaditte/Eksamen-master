package Graphs_Trees.Tree;

public class Tree{
    int value;
    Tree left;
    Tree right;

    public Tree(int value){
        this.value = value;
    }
    public void add(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new Tree(value);
            } else {
                left.add(value);
            }
        }else {
            if (right == null) {
                right = new Tree(value);
            } else {
                right.add(value);
            }
        }
    }

    public void printInOrder(){
        if (left != null){
            left.printInOrder();
        }
        System.out.println(this.value);
        if (right != null){
            right.printInOrder();
        }
    }
}
