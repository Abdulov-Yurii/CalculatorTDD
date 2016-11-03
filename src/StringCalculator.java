/**
 * Created by employee on 11/3/16.
 */
public class StringCalculator {
    static int add(String numbers) {
        int resultValue = 0;
        String[] numbersArray = numbers.split("[,n]");
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                resultValue += Integer.parseInt(number);
            }
        }
        return resultValue;
    }
}
