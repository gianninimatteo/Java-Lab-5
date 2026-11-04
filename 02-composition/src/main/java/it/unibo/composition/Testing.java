package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        // 1)Creare 3 studenti a piacere
        Student st1 = new Student(1, "Mario", "Rossi", "123", 2020);
        Student st2 = new Student(2, "Luigi", "Bianchi", "456", 2021);
        Student st3 = new Student(3, "Davide", "Verdi", "789", 2022);

        // 2)Creare 2 docenti a piacere
        Professor pr1 = new Professor(1, "Paolo", "Neri", "abc", new String[]{"Matematica"});
        Professor pr2 = new Professor(2, "Veronica", "Gialli", "def", new String[]{"Informatica"});

        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        ExamRoom examRoom1 = new ExamRoom(100, "Descrizione aula 1", true, false);
        ExamRoom examRoom2 = new ExamRoom(80, "Descrizione aula 2", false, true);

        // 4) Creare due esami, uno con nMaxStudents=10, l'altro con nMaxStudents=2
        Exam exam1 = new Exam(1, 10, "Matematica", pr1, examRoom1);
        Exam exam2 = new Exam(2, 2, "Informatica", pr2, examRoom2);

        // 5) Iscrivere tutti e 3 gli studenti agli esami
        exam1.registerStudent(st1);
        exam1.registerStudent(st2);
        exam1.registerStudent(st3);

        exam2.registerStudent(st1);
        exam2.registerStudent(st2);
        exam2.registerStudent(st3);

        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(exam1.toString());
        System.out.println(exam2.toString());
    }
}
