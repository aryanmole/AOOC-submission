import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stationary extends JFrame implements ActionListener {
    JCheckBox notebook, pen, pencil;
    JButton order;

    public Stationary() {
        setTitle("Stationary Purchase System");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        notebook = new JCheckBox("Notebook @ 30");
        pen = new JCheckBox("Pen @ 30");
        pencil = new JCheckBox("Pencil @ 30");
        order = new JButton("Order");

        add(notebook);
        add(pen);
        add(pencil);
        add(order);

        order.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double total = 0;
        String message = "";

        if (notebook.isSelected()) {
            String qty = JOptionPane.showInputDialog("Enter quantity for Notebook:");
            int q = Integer.parseInt(qty);
            total += q * 30;
            message += "Notebook: " + q + " x 30 = " + (q * 30) + "\n";
        }

        if (pen.isSelected()) {
            String qty = JOptionPane.showInputDialog("Enter quantity for Pen:");
            int q = Integer.parseInt(qty);
            total += q * 30;
            message += "Pen: " + q + " x 30 = " + (q * 30) + "\n";
        }

        if (pencil.isSelected()) {
            String qty = JOptionPane.showInputDialog("Enter quantity for Pencil:");
            int q = Integer.parseInt(qty);
            total += q * 30;
            message += "Pencil: " + q + " x 30 = " + (q * 30) + "\n";
        }

        else {
            message += "---------------------\nTotal: " + total;
            JOptionPane.showMessageDialog(this, message, "Bill", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Successfully Ordered!", "Confirmation", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Stationary();
    }
}
