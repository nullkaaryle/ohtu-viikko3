package ohtu;

/**
 * Laajenna ohjelmaa siten, että se lisää tulostukseen myös kurssin nimen ja
 * viikoittaiset tehtävien maksimimäärät.
 */
public class Course {

    private String name;
    private String term;
    private String week1;
    private String week2;
    private String week3;
    private String week4;
    private String week5;
    private String week6;

    public Course() {
    }

    public String courseInfoToString() {
        return "Kurssi: " + name + ", " + term;
    }

    public String getWeek1() {
        return week1;
    }

    public String getWeek2() {
        return week2;
    }

    public String getWeek3() {
        return week3;
    }

    public String getWeek4() {
        return week4;
    }

    public String getWeek5() {
        return week5;
    }

    public String getWeek6() {
        return week6;
    }

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public String getWeeksMaxExerciseNumber(int courseweek) {
        if (courseweek == 1) {
            return week1;
        }

        if (courseweek == 2) {
            return week2;
        }

        if (courseweek == 3) {
            return week3;
        }

        if (courseweek == 4) {
            return week4;
        }

        if (courseweek == 5) {
            return week5;
        }

        return week6;
    }

}
