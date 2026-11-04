package it.unibo.composition;

import java.util.Arrays;

public class Exam {
    
    private final int id;
    private final int maxStudents;
    private int registeredStudents = 0; //inizializzato a 0 quindi non deve essere parametro del costruttore
    private final String courseName;
    private final Professor professor;
    private final ExamRoom room;
    private Student[] students; //Inizialmente ci dovranno essere zero studenti registrati. Quindi non lo passiamo nel costruttore

    public Exam(
        final int id,
        final int maxStudents,
        final String courseName,
        final Professor professor,
        final ExamRoom room
    ) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
        this.students = new Student[maxStudents]; //l'array è inizializzato: la dimensione è maxStudents. Senza l'inizializzazione students sarebbe 'null' e non punterebbe a nessun array.
    }

    public int getId() {
        return this.id;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }

    public int getRegisteredStudents() {
        return this.registeredStudents;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public ExamRoom getRoom() {
        return this.room;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public void registerStudent(Student student) {

        if (registeredStudents >= maxStudents) { //controlla se gli studenti registrati all'esame sono > della capacità massima.
            //in questo caso non restituisce nulla
        }
        else {
            students[registeredStudents] = student; //altrimenti inserisce lo studente dentro l'array. 'registeredStudents' indica la posizione del prossimo posto libero nell'array.
            registeredStudents++;
        }
    }

    public String toString() {
        return "Exam [\n"
            + "  id=" + this.id
            + ", maxStudents=" + this.maxStudents
            + ", registeredStudents=" + this.registeredStudents
            + ", courseName=" + this.courseName
            + ", professor=" + this.professor
            + ", room=" + this.room
            + ", students=" + Arrays.toString(students)
            + "\n]";
    }

}
