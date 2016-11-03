import java.util.ArrayList;
import java.util.List;

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
        return add(numbers, delimiter);
    }

    private static int add(String numbers, String delimiter) {
        int resultValue = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        String[] numbersArray = numbers.split(delimiter);
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                int value = Integer.parseInt(number);
                if (value >= 0)
                    resultValue += value;
                else
                    negativeNumbers.add(value);
            }
        }
        if (negativeNumbers.size() != 0){
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return resultValue;
    }
}
