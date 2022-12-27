package workshop;

public class FizzBuzz {
    public static String sayAppropriateString(int number) {
        String strReturn = "";
        if (number % 3 == 0) strReturn += "Fizz";
        if (number % 5 == 0) strReturn += "Buzz";
        if (strReturn != null) return strReturn;
        return String.valueOf(number);
    }
}
