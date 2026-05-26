package com.viveris.school;

public class Main {

    public static void main(String[] args) {
        // TODO: cas nominaux
        //   - créer un étudiant
        //   - ajouter plusieurs notes
        //   - afficher la moyenne
        //   - afficher la note la plus haute et la plus basse
        //   - afficher les matières en échec
        Student student1 = new Student("abdel");
        student1.addGrade(new Grade("physics", 13));
        student1.addGrade(new Grade("chemistry", 14));
        student1.addGrade(new Grade("math", 15));
        student1.addGrade(new Grade("philo", 16));
        student1.addGrade(new Grade("geo", 5));

        System.out.println("Moyenne : " + student1.getAverage());
        System.out.println("HighestGrade : " + student1.getHighestGrade());
        System.out.println("LowestGrade : " + student1.getLowestGrade());

        for (Grade grade : student1.getFailingGrades()) {
            System.out.println(grade.getMatter()  + ":" + grade.getNote());
        }

        System.out.println("FailingGrades " +  student1.getFailingGrades());


        // TODO: cas limites
        //   - moyenne sans aucune note
        //   - note max/min sans aucune note
        //   - ajouter deux notes pour la même matière
        //   - note invalide (< 0 ou > 20)
        //   - nom null ou vide
        Student student2 = new Student("léo");
        System.out.println(student2.getName() + "Moyenne : " + student2.getAverage());
        System.out.println(student2.getName() + "HighestGrade : " + student2.getHighestGrade());
        System.out.println(student2.getName() + "LowestGrade : " + student2.getLowestGrade());
        student2.addGrade(new Grade("physics", 13));
        student2.addGrade(new Grade("chemistry", 14));
        student2.addGrade(new Grade("chemistry", -5));

        Student student3 = new Student("");
    }
}
