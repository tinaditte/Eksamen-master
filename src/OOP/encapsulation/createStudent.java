package OOP.encapsulation;

public class createStudent {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Tina");
        student.setID("tina3246");
        student.setCourse("SWC");

        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getID());
        System.out.println("Course: " + student.getCourse());
    }
}
