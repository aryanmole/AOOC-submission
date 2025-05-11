import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="FactorialApplet" width=300 height=200></applet>
*/

public class FactorialApplet extends Applet implements ActionListener {
    TextField input;
    Label result;
    Button calc;

    public void init() {
        setLayout(new FlowLayout());

        add(new Label("Enter a number:"));
        input = new TextField(10);
        add(input);

        calc = new Button("Calculate Factorial");
        add(calc);
        calc.addActionListener(this);

        result = new Label("");
        add(result);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(input.getText());
            if (num < 0) {
                result.setText("Enter non-negative number");
                return;
            }
            long fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            result.setText("Factorial: " + fact);
        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }
}
