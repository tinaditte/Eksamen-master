package JavaStreams.NotesAndStuff.Stream.Streamsnips.Streamsnips;

public class Person {
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return name;
    }
}
