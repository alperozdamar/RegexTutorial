import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFindReplace {

    public static void main(String args[]) {
        // The regex pattern
        String REGEX_PATTERN = "([0-9]+)x([0-9]+)";
        String inputFileName = "regex25.txt"; //"sed -r 's/([0-9]+)x([0-9]+)/\\1 pix by \\2 pix /g' regex25_sed.txt"


        REGEX_PATTERN = "([a-zA-Z]+)\\s([a-zA-Z]+)";
        inputFileName = "regex26.txt";
        REGEX_PATTERN = "([0-9]{1,2}):([0-9]{1,2})";  //7:32 -> 32 mins past 7  
        inputFileName = "regex27.txt";
        REGEX_PATTERN = "[0-9]{3}\\.[0-9]{3}\\.([0-9]{4})"; //914.582.3013 -> xxx.xxx.3013 
        inputFileName = "regex28.txt";
        REGEX_PATTERN = "([a-zA-Z]{3})\\s([0-9]{1,2})[a-z]{2}\\s[0-9]{2}([0-9]{2})"; //Jan 5th 1987 -> 5-Jan-87
        inputFileName = "regex29.txt";
        REGEX_PATTERN = "\\(([0-9]{3})\\)(\\.[0-9]{3}\\.[0-9]{4})"; //(914).582.3013 -> 914.582.3013
        inputFileName = "regex30.txt";

        // Create a Pattern object
        Pattern r = Pattern.compile(REGEX_PATTERN);

        // Read the input file line by line
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(RegexFindReplace.class.getClassLoader().getResourceAsStream(inputFileName)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                // Now create matcher object.
                Matcher m = r.matcher(line);

                // Apply the regex pattern to each line
                // If pattern matches, perform replacement on the current line.
                if (m.find()) {
                    //line = m.replaceAll(m.group(1) + " pix by " + m.group(2) + " pix");
                    //line = m.replaceAll(m.group(2) + "," + m.group(1));
                    //line = m.replaceAll(m.group(2) + " mins past " + m.group(1));
                    //line = m.replaceAll("xxx.xxx." + m.group(1));
                    //line = m.replaceAll(m.group(2) + "-" + m.group(1) + "-" + m.group(3));
                    line = m.replaceAll(m.group(1) + m.group(2));
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
