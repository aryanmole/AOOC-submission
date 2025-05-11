import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stack = new int[5];
        int top = -1;
        int n;

        do {
            System.out.println("\n=== Stack Menu ===");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            n = sc.nextInt();

            switch (n) {
                case 1:
                    if (top == 4) {
                        System.out.println("Stack Overflow");
                    } else {
                        System.out.print("Enter value to push: ");
                        int value = sc.nextInt();
                        top++;
                        stack[top] = value;
                        System.out.println("Pushed: " + value);
                    }
                    break;

                case 2:
                    if (top == -1) {
                        System.out.println("Stack Underflow");
                    } else {
                        System.out.println("Popped: " + stack[top]);
                        top--;
                    }
                    break;

                case 3:
                    if (top == -1) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.print("Stack elements: ");
                        for (int i = 0; i <= top; i++) {
                            System.out.print(stack[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (n != 4);

        
    }
}

