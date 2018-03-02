import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String s) {
        if(s.length() == 0) {
            return 0;
        }

        String delimiterString = generateSplitDelimiterString(s);
        s = removeDelimiterDeclaration(s);
        String[] numbers = s.split(delimiterString);

        int sum = 0;

        for(int i = 0; i < numbers.length; i++) {
           sum += Integer.parseInt(numbers[i]);
        }

        return sum;
    }

    private String generateSplitDelimiterString(String s) {
        String delimiterString = ", *|\n";

        Pattern pattern = Pattern.compile("^//\\[(.*)\\]\n");
        Matcher matcher = pattern.matcher(s);


        if(matcher.find()) {
            delimiterString += "|" + matcher.group(1).replaceAll("([\\w\\W])", "\\\\\\\\$1");
        }

        return delimiterString;
    }

    private String removeDelimiterDeclaration(String string) {
        return string.replaceAll("^//.*\n", "");
    }
}
