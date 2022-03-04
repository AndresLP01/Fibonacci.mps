import fibonacci.Fibonnaci;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
/*
    Test class for Fibonacci operations
    ---Base cases---
    fibonacci(0) -> 0: CaseBaseZero()
    fibonacci(1) -> 1: CaseBaseOneTwo()
    fibonacci(2) -> 1: CaseBaseOneTwo()
    ----------------
    Assert Positive entry: CaseNegativeEntry()
    Assert Integer.MAXVALUE: CaseOverExceedIntegerMaxValue() -> Integer.MAXVALUE == 2147483647 so if the output is greater, must return an error
    Assert Positive Output: CasePositiveOutput() -> Check the outputs are >= 0
 */
public class FibonacciTest {
    static Fibonnaci fib;
    @BeforeAll
    static void startup(){
        fib = new Fibonnaci();
    }

    @Test
    public void CaseBaseZero(){
        int expectedValue = 0;
        int obtainedValue = fib.compute(0);

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void CaseBaseOneTwo(){
        int expectedValue = 1;
        int obtainedValueWithOne = fib.compute(1);
        int obtainedValueWithTwo = fib.compute(2);

        assertEquals(expectedValue,obtainedValueWithOne);
        assertEquals(expectedValue,obtainedValueWithTwo);
    }

    @Test
    public void CaseNegativeEntry(){
        var rnd = new Random();
        int[] negativeArray = new int[20];

        for(int i = 0; i < negativeArray.length;i++){
            negativeArray[i] = (-1)*rnd.nextInt(0,6000);
        }
        for(Integer negativeValue: negativeArray){
            assertThrows(InputMismatchException.class, ()-> fib.compute(negativeValue));
        }
    }

    @Test
    public void CaseOverExceedIntegerMaxValue(){
        /*
        Fibonacci(47) return 2971215073 but the maximum value of Integer is 2147483647.
        This limit could be increased changing Integer -> Long but it's interesting keeping Integer type to check the limit.
         */
        var rnd = new Random();
        int[] numbersToCheck = new int[20]; //Random Array of numbers >=47

        for(int i = 0; i < numbersToCheck.length;i++){
            numbersToCheck[i] = rnd.nextInt(Integer.MAX_VALUE - 46)-46;
        }
        for(Integer value: numbersToCheck){
            assertThrows(RuntimeException.class,()->fib.compute(value));
        }

    }

    @Test
    public void CasePositiveOutput(){
        var rnd = new Random();
        int[] numbersToCalculate = new int[20]; //Random Array of valids entries

        for(int i = 0; i < numbersToCalculate.length;i++){
            numbersToCalculate[i] = rnd.nextInt(0,46);
        }
        for(Integer value: numbersToCalculate){
            assertTrue(fib.compute(value) >= 0);
        }
    }
}
