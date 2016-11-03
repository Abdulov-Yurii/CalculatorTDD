/**
 * Created by employee on 11/3/16.
 */
public class StringCalculator {
    static int add(String numbers) {
        int resultValue = 0;
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        } else {
            for (String number : numbersArray) {
                if (!number.isEmpty()) {
                    resultValue += Integer.parseInt(number);
                }
            }
        }
        return resultValue;
    }
}
