package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "012345678";

        if (args.length > 0) {
            studentNr = args[0];
        }

        Gson mapper = new Gson();

        String urlTehtavat = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";
        String bodyTextTehtavat = Request.Get(urlTehtavat).execute().returnContent().asString();
        Submission[] subs = mapper.fromJson(bodyTextTehtavat, Submission[].class);

        String urlKurssi = "https://ohtustats2017.herokuapp.com/courses/1.json";
        String bodyTextKurssi = Request.Get(urlKurssi).execute().returnContent().asString();
        Course course = mapper.fromJson(bodyTextKurssi, Course.class);

        System.out.println("json-muotoinen data tehtävistä:");
        System.out.println(bodyTextTehtavat);
        System.out.println();
        System.out.println("json-muotoinen data kurssista:");
        System.out.println(bodyTextKurssi);
        
        boolean firstPrint = true;
        int completedExercisesTotal = 0;
        int spentHoursTotal = 0;
        
        for (Submission submission : subs) {
            submission.setCourse(course);

            if (firstPrint == true) {
                System.out.println("\n" + submission.getCourse().courseInfoToString());
                System.out.println("\n" + submission.studentNumberToString());
                firstPrint = false;
            }

            System.out.println(submission);
            spentHoursTotal += submission.getHours();
            completedExercisesTotal += submission.getNumberOfCompletedExercises();
        }

        System.out.println("\nyhteensä: " + completedExercisesTotal + " tehtävää " + spentHoursTotal + " tuntia");

    }

}
