package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "Laita oikea nr tähän";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        JsonParser parser = new JsonParser();
        String text = Request.Get("https://ohtustats2017.herokuapp.com/courses/1.json")
                .execute()
                .returnContent()
                .asString();
        Gson papper = new Gson();
         Course course = mapper.fromJson(text, Course.class);
         System.out.println("Kurssi: " + course.toString());
         System.out.println("");

        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");
        int totalTasks = 0;
        int totalTime = 0;
        for (Submission submission : subs) {
            System.out.println(submission);
            totalTasks += submission.getNumberOfTasks();
            totalTime += Integer.parseInt(submission.getHours());
        }
        System.out.println("");
        System.out.println("Yhteensä: " + totalTasks + " tehtävää " + totalTime + " tuntia.");
    }
}
