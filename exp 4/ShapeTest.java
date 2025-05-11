import java.util.Scanner;

interface Shape {
    void area();
}

class Rectangle implements Shape {
    int length, breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void area() {
        int area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle implements Shape {
    int base, height;

    Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public void area() {
        double area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length and breadth of Rectangle: ");
        int l = sc.nextInt();
        int b = sc.nextInt();
        Rectangle r = new Rectangle(l, b);
        r.area();

        System.out.print("Enter base and height of Triangle: ");
        int base = sc.nextInt();
        int height = sc.nextInt();
        Triangle t = new Triangle(base, height);
        t.area();

        sc.close();
    }
}
