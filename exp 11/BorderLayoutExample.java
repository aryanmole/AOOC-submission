import java.awt.*;
import java.awt.event.*;

public class BorderLayoutExample extends Frame implements ActionListener {
    TextField inputField, resultField;
    Button binaryBtn, octalBtn, hexBtn;

    public BorderLayoutExample() {
        setTitle("BorderLayout Example");
        setSize(400, 200);
        setLayout(new BorderLayout());

        // North panel: Label + Input
        Panel northPanel = new Panel(new FlowLayout());
        northPanel.add(new Label("Enter the number"));
        inputField = new TextField(10);
        northPanel.add(inputField);
        add(northPanel, BorderLayout.NORTH);

        // Center panel: Buttons
        Panel centerPanel = new Panel(new GridLayout(1, 3));
        binaryBtn = new Button("Binary");
        octalBtn = new Button("Octal");
        hexBtn = new Button("Hex");

        centerPanel.add(binaryBtn);
        centerPanel.add(octalBtn);
        centerPanel.add(hexBtn);

        add(centerPanel, BorderLayout.CENTER);

        // South panel: Result
        Panel southPanel = new Panel(new FlowLayout());
        southPanel.add(new Label("Result"));
        resultField = new TextField(15);
        resultField.setEditable(false);
        southPanel.add(resultField);
        add(southPanel, BorderLayout.SOUTH);

        // Button actions
        binaryBtn.addActionListener(this);
        octalBtn.addActionListener(this);
        hexBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int number = Integer.parseInt(inputField.getText());
            if (e.getSource() == binaryBtn) {
                resultField.setText(Integer.toBinaryString(number));
            } else if (e.getSource() == octalBtn) {
                resultField.setText(Integer.toOctalString(number));
            } else if (e.getSource() == hexBtn) {
                resultField.setText(Integer.toHexString(number));
            }
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid number!");
        }
    }

    public static void main(String[] args) {
        new BorderLayoutExample();
    }
}
