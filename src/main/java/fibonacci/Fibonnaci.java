package fibonacci;

import java.util.InputMismatchException;

public class Fibonnaci {
    public int compute(int number){
        if (number < 0) // Negative number trap
            throw new InputMismatchException("ERROR: Number: "+number+ " is negative");
        if(number > 46) //Integer Max Value overflow
            throw new RuntimeException("ERROR: The maximum value is 47 due to Integer.MAXVALUE overflow. Your entry was:"+ number);
        int values[] = new int[number+2];
        values[0] = 0; //Base case
        values[1] = 1; //Base case

        for(int i = 2; i<= number; i++){
         values[i] = values[i-1] + values[i-2]; //Insert the new calculated value to use it later
        }
        return values[number];
    }
}
