package interface_Generics.Generics;

public class Main {

    public static void main(String[] args) {
        Tree<String> tina = new Tree<>("Tina");
        tina.leftChild = new Tree<>("Mum");
        tina.rightChild = new Tree<>("Dad");
        tina.leftChild.leftChild = new Tree<>("Mum's mum");

        Tree<Integer> integers = new Tree<>(0);
        integers.leftChild = new Tree<>(-1);
        integers.rightChild = new Tree<>(1);

    }
}
