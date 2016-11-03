/**
 * Created by employee on 11/3/16.
 */
public class StringCalculator {

    public static int add(String numbers) {
        String delimiter = "[,n]";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, numbers.indexOf("n"));
            numbers = numbers.substring(numbers.indexOf("n") + 1 );
        }
        return addWithoutDelimiter(numbers, delimiter);
    }

    private static int addWithoutDelimiter(String numbers, String delimiter) {
        int resultValue = 0;

        String[] numbersArray = numbers.split(delimiter);
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                resultValue += Integer.parseInt(number);
            }
        }
        return resultValue;
    }
}
