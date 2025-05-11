import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall extends JPanel implements Runnable, MouseListener {
    private int x = 50, y = 50;
    private int diameter = 30;
    private int dx = 2, dy = 2;
    private boolean running = false;

    public BouncingBall() {
        setBackground(Color.WHITE);
        addMouseListener(this);
        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public void run() {
        while (running) {
            x += dx;
            y += dy;

            // Bounce on edges
            if (x <= 0 || x + diameter >= getWidth()) {
                dx *= -1;
            }
            if (y <= 0 || y + diameter >= getHeight()) {
                dy *= -1;
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!running) {
            running = true;
            new Thread(this).start();
        }
    }

    // Unused mouse events
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall ballPanel = new BouncingBall();
        frame.add(ballPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
