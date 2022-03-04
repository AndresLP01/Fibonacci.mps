import fibonacci.Fibonnaci;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
 */
public class FibonacciTest {
    Fibonnaci fib;
    @BeforeEach
    public void startup(){
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
}
