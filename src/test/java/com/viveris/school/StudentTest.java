package com.viveris.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        // TODO: initialiser un étudiant de test
    }

    @Test
    void getAverage_should_return_correct_average() {
        // TODO
    }

    @Test
    void getAverage_should_return_zero_when_no_grades() {
        // TODO
    }

    @Test
    void getHighestGrade_should_return_empty_when_no_grades() {
        // TODO
    }

    @Test
    void getLowestGrade_should_return_correct_grade() {
        // TODO
    }

    @Test
    void getFailingGrades_should_return_only_grades_below_10() {
        // TODO
    }

    @Test
    void addGrade_should_throw_when_subject_already_exists() {
        // TODO: vérifier qu'on ne peut pas ajouter deux notes pour la même matière
    }

    @Test
    void grade_constructor_should_throw_when_value_out_of_range() {
        // TODO: note < 0 et note > 20
    }

    @Test
    void constructor_should_throw_when_name_is_blank() {
        // TODO
    }
}
