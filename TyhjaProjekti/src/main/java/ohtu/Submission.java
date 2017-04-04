package ohtu;

import java.util.ArrayList;
import java.util.List;

/**
 * Jokainen Submission-olio vastaa yhden viikon palautusta. Tee luokkaan
 * oliomuuttuja (sekä tarvittaessa getteri ja setteri) jokaiselle json-datassa
 * olevalle kentälle, jota ohjelmasi tarvitsee. Kentät a1, a2 jne vastaavat
 * viikolla tehtyjä yksittäisiä tehtäviä.
 */
public class Submission {

    private String student_number;
    private int week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;
    private List<Integer> completedExercises;
    private Course course;

    public Submission() {
        this.completedExercises = new ArrayList<>();
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setCourse(Course newCourse) {
        this.course = newCourse;
    }

    public Course getCourse() {
        return course;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getHours() {
        return this.hours;
    }

    public int getNumberOfCompletedExercises() {
        return countCompletedExercises();
    }

    @Override
    public String toString() {
        return weekToString()
                + numberOfCompletedExercisesToString()
                + weeksMaxExerciseNumberToString()
                + hoursToString()
                + exercisesToString();
    }

    public String weeksMaxExerciseNumberToString() {
        return " (maksimi " + course.getWeeksMaxExerciseNumber(week) + "), ";
    }

    public String studentNumberToString() {
        return "opiskelijanumero: " + student_number + "\n";
    }

    public String weekToString() {
        return " viikko " + week + ": ";
    }

    public String numberOfCompletedExercisesToString() {
        return "tehtyjä tehtäviä yhteensä: " + countCompletedExercises();
    }

    public String hoursToString() {
        return "aikaa kului " + hours + " tuntia,";
    }

    public String exercisesToString() {
        String completedExercisesAsAString = "";

        for (int exercise : this.completedExercises) {
            completedExercisesAsAString += exercise + " ";
        }

        return " tehdyt tehtävät: " + completedExercisesAsAString;
    }

    public int countCompletedExercises() {
        int completedExercises = 0;

        if (a1 == true) {
            completedExercises++;
            this.completedExercises.add(1);
        }
        if (a2 == true) {
            completedExercises++;
            this.completedExercises.add(2);
        }
        if (a3 == true) {
            completedExercises++;
            this.completedExercises.add(3);
        }
        if (a4 == true) {
            completedExercises++;
            this.completedExercises.add(4);
        }
        if (a5 == true) {
            completedExercises++;
            this.completedExercises.add(5);
        }
        if (a6 == true) {
            completedExercises++;
            this.completedExercises.add(6);
        }
        if (a7 == true) {
            completedExercises++;
            this.completedExercises.add(7);
        }
        if (a8 == true) {
            completedExercises++;
            this.completedExercises.add(8);
        }
        if (a9 == true) {
            completedExercises++;
            this.completedExercises.add(9);
        }
        if (a10 == true) {
            completedExercises++;
            this.completedExercises.add(10);
        }
        if (a11 == true) {
            completedExercises++;
            this.completedExercises.add(11);
        }
        if (a12 == true) {
            completedExercises++;
            this.completedExercises.add(12);
        }
        if (a13 == true) {
            completedExercises++;
            this.completedExercises.add(13);
        }
        if (a14 == true) {
            completedExercises++;
            this.completedExercises.add(14);
        }
        if (a15 == true) {
            completedExercises++;
            this.completedExercises.add(15);
        }
        if (a16 == true) {
            completedExercises++;
            this.completedExercises.add(16);
        }
        if (a17 == true) {
            completedExercises++;
            this.completedExercises.add(17);
        }
        if (a18 == true) {
            completedExercises++;
            this.completedExercises.add(18);
        }
        if (a19 == true) {
            completedExercises++;
            this.completedExercises.add(19);
        }
        if (a20 == true) {
            completedExercises++;
            this.completedExercises.add(20);
        }
        if (a21 == true) {
            completedExercises++;
            this.completedExercises.add(21);
        }

        return completedExercises;
    }

}
