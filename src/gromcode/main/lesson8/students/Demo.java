package gromcode.main.lesson8.students;

public class Demo {

    Student createHighestParent() {
        return new Student("Andrei", "Andrei", 1, new Course[3]);
    }
    SpecialStudent createLowestChild() {
        return new SpecialStudent("Andrei", "Andrei", 1, new Course[3], 5235235, "user@mail.com");
    }
}
