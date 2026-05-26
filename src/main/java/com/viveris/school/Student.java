package com.viveris.school;

import java.util.*;

public class Student {

    // TODO: attributs (nom, liste de notes)
    private final String name;
    private final List<Grade> grades;
    // TODO: constructeur — valider le nom

    public Student(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        this.name = name;
        this.grades = new ArrayList<>();
    }

    /**
     * Ajoute une note pour une matière.
     * Une matière ne peut avoir qu'une seule note.
     *
     * @throws IllegalArgumentException si la matière a déjà une note
     */
    public void addGrade(Grade grade) {
        if (grade.getMatter().isBlank()) {
            throw new IllegalArgumentException("matter is empty");
        } else if (grade.getNote() < 0) {
            throw new IllegalArgumentException("note is negative");
        } else if (alreadyExisted(grade.getMatter())) {
            throw new IllegalArgumentException("matter already exists");
        }
        this.grades.add(grade);
    }

    /**
     * Calcule la moyenne générale de toutes les notes.
     * Retourne 0.0 si aucune note n'a été ajoutée.
     */
    public double getAverage() {
        return grades.stream()
                .mapToDouble(Grade::getNote)
                .average()
                .orElse(0.0);
    }

    /**
     * Retourne la note la plus haute.
     * Retourne Optional.empty() si aucune note n'existe.
     */
    public Optional<Grade> getHighestGrade() {
        return grades.stream().max(Comparator.comparingDouble(Grade::getNote));
    }

    /**
     * Retourne la note la plus basse.
     * Retourne Optional.empty() si aucune note n'existe.
     */
    public Optional<Grade> getLowestGrade() {
        // TODO
        return grades.stream().min(Comparator.comparingDouble(Grade::getNote));
    }

    boolean alreadyExisted(String matter) {
        return grades.stream().anyMatch(grade -> grade.getMatter().equals(matter));
    }

    /**
     * Retourne la liste des matières en échec (note < 10).
     * Retourne une liste vide si aucune matière n'est en échec.
     */
    public List<Grade> getFailingGrades() {
        return grades.stream()
                .filter(grade -> grade.getNote() < 10)
                .toList();
    }

    // TODO: getter pour le nom
    public String getName() {
        return name;
    }

    public List<Grade> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    // TODO: toString()

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
