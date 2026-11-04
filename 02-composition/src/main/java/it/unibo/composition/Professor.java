package it.unibo.composition;

import java.util.Arrays; //converte il contenuto dell'array in una stringa leggibile, così puoi stampare i singoli corsi invece del riferimento all'array (riga 41).

public class Professor implements User {

    private static final String DOT = ".";
    private final int id;
    private final String name;
    private final String surname;
    private final String password;
    private String[] courses;

    public Professor(
        final int id,
        final String name,
        final String surname,
        final String password,
        final String[] courses
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.courses = courses;
    }

    public void replaceCourse(final String course, final int index) { //Sostituisce un singolo corso nell'array, alla posizione indicata.
        this.courses[index] = course;
    }

    public void replaceAllCourses(final String[] courses) { //Sostituisce l'intero array di corsi con un nuovo array fornito in input.
        this.courses = courses;
    }

     public String toString() {
        return "Professor ["
            + "name=" + this.name
            + ", surname=" + this.surname
            + ", id=" + this.id
            + ", courses=" + Arrays.toString(courses)
            + "]";
    }

    public String getUsername() {
        return this.name + Professor.DOT + this.surname;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDescription() {
        return this.toString();
    }
}
