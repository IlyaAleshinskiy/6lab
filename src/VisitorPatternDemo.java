// VisitorPatternDemo.java
interface Person {
    void accept(Visitor visitor);
}

class Student implements Person {
    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Professor implements Person {
    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}


interface Visitor {
    void visit(Student student);
    void visit(Professor professor);
}

class Session implements Visitor {
    @Override public void visit(Student student) {
        System.out.println("Студент сдает экзамены");
    }

    @Override public void visit(Professor professor) {
        System.out.println("Профессор принимает экзамены");
    }
}

class Vacation implements Visitor {
    @Override public void visit(Student student) {
        System.out.println("Студент отдыхает");
    }

    @Override public void visit(Professor professor) {
        System.out.println("Профессор уходит в отпуск");
    }
}


public class VisitorPatternDemo {
    public static void main(String[] args) {
        // Часть 1: Базовая демонстрация
        System.out.println("=== Базовая демонстрация ===");
        Person[] people1 = {new Student(), new Professor()};
        demoOperations(people1);
    }

    private static void demoOperations(Person[] people) {
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

    private static void demoWithPostgraduate(Person[] people) {
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