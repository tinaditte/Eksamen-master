package Graphs_Trees.Tree;

public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree(5);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(4);
        tree.printInOrder();
    }
}
