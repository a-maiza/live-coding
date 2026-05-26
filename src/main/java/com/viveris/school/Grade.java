package com.viveris.school;

import java.util.Collections;

public class Grade {

    // TODO: attributs (matière, valeur de la note)
    private final String matter;
    private final Double note;

    // TODO: constructeur — valider que la note est entre 0 et 20 inclus
    public Grade(String matter, double note) {
        if (matter == null || matter.isBlank()) {
            throw new IllegalArgumentException("matter is empty");
        }
        if (note < 0 || note > 20) {
            throw new IllegalArgumentException("note is out of range");
        }
        this.note = note;
        this.matter = matter;
    }

    // TODO: getters

    public String getMatter() {
        return matter;
    }

    public double getNote() {
        return note;
    }

    // TODO: toString()
    @Override
    public String toString() {
        return "Grade{" +
                "matter='" + matter + '\'' +
                ", note=" + note +
                '}';
    }
}
