package interface_Generics.Generics;

public class Tree<T> {
    public T value;
    public Tree<T> leftChild;
    public Tree<T> rightChild;

    public Tree(T value){
        this.value = value;
    }


}
