import java.util.Scanner;
import java.io.IOException;

// https://jsoup.org/ for getting html 
import org.jsoup.*;
import org.jsoup.nodes.*;

public class SCChallengeEmail {
    public static void main(String[] args) throws IOException {
        // Take username input
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter username: ");
        String id = myObj.nextLine();
        myObj.close();
        // Couldn't get my own name to come up on https://www.ecs.soton.ac.uk/people/ so
        // I'm using the secure ones and copying some cookie data from own browser that
        // requested something from secure.ecs beforehand for it to work

        Document doc = Jsoup.connect(String.format("http://secure.ecs.soton.ac.uk/people/%s", id))
                .cookie("COOKIE_NAME", "COOKIE_VALUE").get();
        // Returns ECS - NAME as the title of the webpage so parse that ezpz print name
        System.out.println(doc.title().replace("ECS - ", ""));

    }
}