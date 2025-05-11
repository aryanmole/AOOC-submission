import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopwatchApp extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private int seconds = 0;
    private boolean running = false;
    private Thread thread;

    public StopwatchApp() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("0", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(timeLabel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        panel.add(startButton);
        panel.add(stopButton);
        panel.add(resetButton);

        add(panel, BorderLayout.SOUTH);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    public void startStopwatch() {
        thread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(1000);
                    seconds++;
                    timeLabel.setText(String.valueOf(seconds));
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        thread.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!running) {
                running = true;
                startStopwatch();
            }
        } else if (e.getSource() == stopButton) {
            running = false;
        } else if (e.getSource() == resetButton) {
            running = false;
            seconds = 0;
            timeLabel.setText("0");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StopwatchApp().setVisible(true);
        });
    }
}
