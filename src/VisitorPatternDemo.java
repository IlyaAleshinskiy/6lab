// VisitorPatternDemo.java
interface Person {
    void accept(Visitor visitor);
}

class Student implements Person {
    @Override public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Часть 3: Добавляем аспиранта
class Postgraduate implements Person {
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
    // Часть 3: Добавляем метод для аспиранта
    void visit(Postgraduate postgraduate);
}

class Session implements Visitor {
    @Override public void visit(Student student) {
        System.out.println("Студент сдает экзамены");
    }

    @Override public void visit(Professor professor) {
        System.out.println("Профессор принимает экзамены");
    }

    // Часть 3: Реализация для аспиранта
    @Override public void visit(Postgraduate postgraduate) {
        System.out.println("Аспирант сдает кандидатский минимум");
    }
}

class Vacation implements Visitor {
    @Override public void visit(Student student) {
        System.out.println("Студент отдыхает");
    }

    @Override public void visit(Professor professor) {
        System.out.println("Профессор уходит в отпуск");
    }

    // Часть 3: Реализация для аспиранта
    @Override public void visit(Postgraduate postgraduate) {
        System.out.println("Аспирант работает над диссертацией");
    }
}

// Часть 2: Добавляем аттестацию
class Attestation implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("Студент проходит аттестацию");
    }

    @Override
    public void visit(Professor professor) {
        System.out.println("Профессор проводит аттестацию");
    }

    // Часть 3: Реализация для аспиранта
    @Override public void visit(Postgraduate postgraduate) {
        System.out.println("Аспирант защищает отчет по НИР");
    }
}


public class VisitorPatternDemo {
    public static void main(String[] args) {
        // Часть 1: Базовая демонстрация
        System.out.println("=== Базовая демонстрация ===");
        Person[] people1 = {new Student(), new Professor()};
        demoOperations(people1);

        // Часть 2: Добавляем аттестацию
        System.out.println("\n=== С аттестацией ===");
        Person[] people2 = {new Student(), new Professor()};
        demoWithAttestation(people2);

        // Часть 3: Добавляем аспиранта
        System.out.println("\n=== С аспирантом ===");
        Person[] people3 = {new Student(), new Professor(), new Postgraduate()};
        demoWithPostgraduate(people3);
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
        Visitor attestation = new Attestation();

        System.out.println("Сессия:");
        for (Person person : people) {
            person.accept(session);
        }

        System.out.println("\nКаникулы:");
        for (Person person : people) {
            person.accept(vacation);
        }

        System.out.println("\nАттестация:");
        for (Person person : people) {
            person.accept(attestation);
        }
    }

    private static void demoWithAttestation(Person[] people) {
        Visitor attestation = new Attestation();
        demoOperations(people);

        System.out.println("\nАттестация:");
        for (Person person : people) {
            person.accept(attestation);
        }
    }
}