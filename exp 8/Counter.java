import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Counter{
	public static void main(String[] args){
		
		JFrame frame=new JFrame("Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		frame.setLayout(new FlowLayout());
		
		JLabel label=new JLabel("Counter");
		
		JTextField textfield =new JTextField("0",5);
		textfield.setEditable(false);
		
		JButton upbutton=new JButton("counter up");
		JButton downbutton=new JButton("counter down");
		JButton resetbutton=new JButton("counter reset");
		
		frame.add(label);
		frame.add(textfield);
		frame.add(upbutton);
		frame.add(downbutton);
		frame.add(resetbutton);
		
		final int[] counter={0};
		
		upbutton.addActionListener(e->{
		  counter[0]++;
		  textfield.setText(String.valueOf(counter[0]));
		});
		downbutton.addActionListener(e->{
		  counter[0]--;
		  textfield.setText(String.valueOf(counter[0]));
		});
		resetbutton.addActionListener(e->{
		  counter[0]=0;
		  textfield.setText(String.valueOf(counter[0]));
		});
		frame.setVisible(true);
	}
}
