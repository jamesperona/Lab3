import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/***
 *
 * @author jameslp2
 *
 */
public class Lab3 {
    /***
     *
     * @param args because he told me to
     *
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a valid URL:");
        String inputLink = scan.nextLine();
        String pageText = urlToString(inputLink);
        System.out.println(pageText);
        scan.close();

        int pageLength = pageText.length();
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < pageLength; i++) {
            if (Character.isLetter(pageText.charAt(i))) {
                inWord = true;
            }

            if (pageText.charAt(i) == ' ') {
                if (inWord == true) {
                    wordCount++;
                }

                inWord = false;
            }

        }
        System.out.println("Number of words: " + wordCount);

    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
