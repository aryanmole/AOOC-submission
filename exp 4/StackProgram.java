import java.util.Scanner;

interface Stack {
    int size = 5;
    void push(int element);
    void pop();
    void display();
    boolean overflow();
    boolean underflow();
}

public class StackProgram implements Stack {
    int[] stack = new int[size];
    int top = -1;

    public void push(int element) {
        if (overflow()) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = element;
    }

    public void pop() {
        if (underflow()) {
            System.out.println("Stack Underflow");
            return;
        }
        top--;
    }

    public void display() {
        if (underflow()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public boolean overflow() {
        return top == size - 1;
    }

    public boolean underflow() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackProgram s = new StackProgram();
        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\n1. Push\n2. Pop\n3. Display\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    s.push(value);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        sc.close();
    }
}
