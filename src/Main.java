import java.util.*;
// Person.java
public interface Person {
    void accept(Visitor visitor);
}

// Student.java
public class Student implements Person {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Professor.java
public class Professor implements Person {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Visitor.java
public interface Visitor {
    void visit(Student student);
    void visit(Professor professor);
}

// Session.java
public class Session implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("Студент сдает экзамены");
    }

    @Override
    public void visit(Professor professor) {
        System.out.println("Профессор принимает экзамены");
    }
}

// Vacation.java
public class Vacation implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("Студент отдыхает");
    }

    @Override
    public void visit(Professor professor) {
        System.out.println("Профессор уходит в отпуск");
    }
}
public class Main {
    public static void main(String[] args) {
        Person[] people = {new Student(), new Professor()};
        Visitor session = new Session();
        Visitor vacation = new Vacation();

        System.out.println("Сессия:");
        for (Person person : people) {
            person.accept(session);
        }

        System.out.println("\nКаникулы:");
        for (Person person : people) {
            person.accept(vacation);
        }
    }
}