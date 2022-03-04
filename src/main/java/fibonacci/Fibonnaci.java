package fibonacci;

import java.util.InputMismatchException;

public class Fibonnaci {
    public int compute(int number){
        if (number < 0)
            throw new InputMismatchException("ERROR: Number: "+number+ " is negative");
        return number;
    }
}
