import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gender{
	public static void main(String[] args){
		
		JFrame frame=new JFrame("Reverse number");
		frame.setSize(300,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JLabel inputlabel=new JLabel("Select gender=");

		JRadioButton malebutton=new JRadioButton("Male");
		JRadioButton femalebutton=new JRadioButton("Female");
		JRadioButton otherbutton=new JRadioButton("Others");

		JTextField outputfield=new JTextField(10);
		outputfield.setEditable(false);

		frame.add(inputlabel);
		frame.add(malebutton);
		frame.add(femalebutton);
		frame.add(otherbutton);
		frame.add(outputfield);

		malebutton.addActionListener(e->{
			outputfield.setText("Male");
});
		femalebutton.addActionListener(e->{
			outputfield.setText("Female");
});
		otherbutton.addActionListener(e->{
			outputfield.setText("Others");
});
		frame.setVisible(true);
		
 }
}