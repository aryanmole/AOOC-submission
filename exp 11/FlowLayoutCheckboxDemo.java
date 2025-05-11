import java.awt.*;
import javax.swing.*;

public class FlowLayoutCheckboxDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // FlowLayout with LEFT alignment, hgap=10, vgap=20
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        JCheckBox javaCB = new JCheckBox("Java");
        JCheckBox pythonCB = new JCheckBox("Python");
        JCheckBox cppCB = new JCheckBox("C++");

        frame.add(javaCB);
        frame.add(pythonCB);
        frame.add(cppCB);

        frame.setVisible(true);
    }
}
