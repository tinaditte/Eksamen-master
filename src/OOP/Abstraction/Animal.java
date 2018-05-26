package OOP.Abstraction;

public abstract class Animal {
    public String nickname;
    public abstract String sound();

    public void cry(){
        System.out.println(nickname + " says " + this.sound());
    }

}
