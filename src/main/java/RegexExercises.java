import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExercises {

    public static void main(String args[]) {
        /**
         * BASIC SET
         */
        // The regex pattern
        String REGEX_PATTERN = "fooa*bar";
        String inputFileName = "regex01.txt";
        REGEX_PATTERN = "foo.bar";
        inputFileName = "regex02.txt";
        REGEX_PATTERN = "foo.*bar";
        inputFileName = "regex03.txt";
        REGEX_PATTERN = "foo\\s*bar";
        inputFileName = "regex04.txt";
        REGEX_PATTERN = "[fcl]oo";
        inputFileName = "regex05.txt";
        REGEX_PATTERN = "[fcdplb]oo";
        inputFileName = "regex06.txt";
        REGEX_PATTERN = "[^mh]oo"; //Excludes...
        inputFileName = "regex07.txt";
        REGEX_PATTERN = "[j-m]oo"; //Range (j k l m)
        inputFileName = "regex08.txt";
        REGEX_PATTERN = "[j-mz]oo"; //Range+charachter
        inputFileName = "regex09.txt";
        REGEX_PATTERN = "[j-mJ-Mz]oo"; //Union of Ranges
        inputFileName = "regex10.txt";
        REGEX_PATTERN = "x*\\.y*"; //Escape character. \ Backslash Special Characters ^$*.[()\
        inputFileName = "regex11.txt";
        REGEX_PATTERN = "x[.:#]y"; //If .(period) inside square brackets, it need NOT be escaped.
        inputFileName = "regex12.txt";
        REGEX_PATTERN = "x[\\^:#]y"; // Even in square brackets, ^ is a special character. So you need to escape it, in case you need to use that charachter.
        inputFileName = "regex13.txt";
        REGEX_PATTERN = "x[\\^\\\\#]y"; //Backslash itself should always be escaped with a backslash
        inputFileName = "regex14.txt";
        REGEX_PATTERN = "foo .* ba[rz]";
        REGEX_PATTERN = "^foo.*"; //Anchor ^ is a placeholder that signifies beginning of a line. The interpretation of ^ differs within square brackers and outside of it. Inside square brackets, ^ stands for negation. Outside, it is a placeholder for beginning of line.  
        inputFileName = "regex15.txt";
        REGEX_PATTERN = ".* bar$"; //$ is a placeholder that signifies end of a line.
        inputFileName = "regex16.txt";
        REGEX_PATTERN = "^foo$"; // Only foo. ^ is a placeholder that signifies beginning of a line.$ is a placeholder that signifies end of a line.
        inputFileName = "regex17.txt";
        /**
         * EXTENDED SET
         */
        REGEX_PATTERN = "^[0-9][0-9][0-9]$";
        REGEX_PATTERN = "^[0-9]{3}$"; // a{m} represents exactly 'm' repetitions of whatever immediately precedes this, i.e. 'a'.  
        inputFileName = "regex18.txt";
        REGEX_PATTERN = "^[a-z]{4,6}$";
        inputFileName = "regex19.txt"; // a{m,n} represents at least 'm' and at most 'n' repetitions of whatever immediately precedes this, i.e. 'a'.    
        REGEX_PATTERN = "(ha){4,}";
        inputFileName = "regex20.txt";    // () Paranthesis is used to group and treat as a single entity.    
        // {m,} represents at least 'm' repetitions of whatever immediately precedes this.
        REGEX_PATTERN = "^(ha){1,2}$";
        inputFileName = "regex21.txt";    // () Paranthesis is used to group and treat as a single entity.    
        // {,n} represents at most 'n' repetitions of whatever immediately precedes this.
        REGEX_PATTERN = "^fooa+bar$"; // a+ One or more occurrences of 'a'. (The character just preceding the plus symbol)
        inputFileName = "regex22.txt";
        REGEX_PATTERN = "^https?://website$";                    // My answer : "^http(s){0,1}://website$"; 
        // a? - Zero or one occurences of 'a' (The character just preceding the question mar)
        inputFileName = "regex23.txt";
        REGEX_PATTERN = "^(log|ply)wood$";         // (a|b) represebts either a or b, where a and b can be multi-character strings.
        inputFileName = "regex24.txt";

        // Create a Pattern object
        Pattern r = Pattern.compile(REGEX_PATTERN);
        runRegex(inputFileName, r);
    }

    private static void runRegex(String inputFileName, Pattern r) {
        // Read the input file line by line
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(RegexExercises.class.getClassLoader().getResourceAsStream(inputFileName)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                // Now create matcher object.
                Matcher m = r.matcher(line);

                // Apply the regex pattern to each line
                // If pattern matches, output the current line.
                if (m.find()) {
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
