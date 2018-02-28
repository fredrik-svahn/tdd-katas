import java.util.regex.*;


public class StringCalculator {
    public int calculate(String string) {
        if(string.isEmpty()) {
            return 0;
        }

        // Find delimiter declaration
        Pattern pattern = Pattern.compile("^\\/\\/\\[([^\\[\\]]+)\\]\\n.*");
        Matcher matcher = pattern.matcher(string);
        String splitString = "";

        if(matcher.matches()) {
            for(int i = 1; i < matcher.groupCount() + 1; i++) {
                splitString += matcher.group(i);
                if(i != matcher.groupCount()) {
                    splitString += "|";
                }
            }
        }


        string = string.replaceAll("^\\/\\/\\[([^\\[\\]])\\]\\n", "");
        int sum = 0;

        String[] numbers = string.split("[,|\n|"+splitString+"]");

        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
