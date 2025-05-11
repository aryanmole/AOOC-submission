import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridSwap extends JFrame implements ActionListener {
    JButton[] buttons = new JButton[6];
    JButton prevClicked = null;

    public GridSwap() {
        setTitle("Grid Layout Swap");
        setLayout(new GridLayout(2, 3));
        setSize(300, 200);

        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (prevClicked == null) {
            prevClicked = clicked;
        } else {
            // Swap the text
            String temp = prevClicked.getText();
            prevClicked.setText(clicked.getText());
            clicked.setText(temp);
            prevClicked = null;
        }
    }

    public static void main(String[] args) {
        new GridSwap();
    }
}
