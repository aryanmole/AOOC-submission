import java.util.Scanner;

class Student {
    int rollNo;

    void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    int getRollNo() {
        return rollNo;
    }
}

class Test extends Student {
    int sub1, sub2;

    void setMarks(int sub1, int sub2) {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    int getSub1() {
        return sub1;
    }

    int getSub2() {
        return sub2;
    }
}

interface Sports {
    int sMarks = 20;
    void set();
}

class Result extends Test implements Sports {
    int total;

    public void set() {
        total = sub1 + sub2 + sMarks;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks in Subject 1: " + sub1);
        System.out.println("Marks in Subject 2: " + sub2);
        System.out.println("Sports Marks: " + sMarks);
        System.out.println("Total Marks: " + total);
    }
}

public class TestApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Result r = new Result();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        r.setRollNo(roll);

        System.out.print("Enter marks for Subject 1 and Subject 2: ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        r.setMarks(m1, m2);

        r.set();
        r.display();

        sc.close();
    }
}
