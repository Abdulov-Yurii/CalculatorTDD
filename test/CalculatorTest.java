import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by employee on 11/3/16.
 */
public class CalculatorTest {
//    @Test(expected = RuntimeException.class)
//    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//        StringCalculator.add("1,2,3");
//    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        Exception exception = null;
        try {
            StringCalculator.add("1,2");
        } catch (Exception e) {
            exception = e;
        }
        assertThat(exception, nullValue());
    }

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        assertThat(0, is(StringCalculator.add("")));
    }

    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        assertThat(3, is(StringCalculator.add("3")));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        assertThat(3 + 6, is(StringCalculator.add("3,6")));
    }

    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        assertThat(3 + 6 + 15 + 18 + 46 + 33, equalTo(StringCalculator.add("3,6,15,18,46,33")));
    }

    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        assertThat(3 + 6 + 15, equalTo(StringCalculator.add("3,6n15")));
    }

    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        assertThat(3 + 6 + 15, equalTo(StringCalculator.add("//;\n3;6;15")));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        StringCalculator.add("3,-6,15,18,46,33");
    }

    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        RuntimeException exception = null;
        try {
            StringCalculator.add("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertThat(exception, notNullValue());
        assertThat("Negatives not allowed: [-6, -18]", equalTo(exception.getMessage()));
    }

    @Test
    public void ignoredMoreThousandValues(){
        assertThat(3 + 1000 + 1, is(StringCalculator.add("3, 1000 , 156498, 1")));
    }

    @Test
    public void anyLengthDelimiter(){
        assertThat(1+2+3, is(StringCalculator.add("//[—]\n1—2—3")));
    }

    @Test
    public void multipleDelimiters(){
        assertThat(1+2+3, is(StringCalculator.add("//[-][%]\n1-2%3")));
    }

}
