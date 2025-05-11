import java.util.Scanner;

class OddNumberException extends Exception {
    OddNumberException(String message) {
        super(message);
    }
}

public class OddNumberChecker {

    static void checkEven(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("The number " + number + " is odd.");
        } else {
            System.out.println("The number " + number + " is even.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        try {
            checkEven(num);
        } catch (OddNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        sc.close();
    }
}
