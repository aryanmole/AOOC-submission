import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reverse{
	public static void main(String[] args){
		
		JFrame frame=new JFrame("Reverse number");
		frame.setSize(300,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JLabel inputlabel=new JLabel("Enter number");
		JTextField inputfield=new JTextField(10);

		JButton rbutton=new JButton("reverse");

		JLabel outputlabel=new JLabel("Reversed number");
		JTextField outputfield=new JTextField(10);
		outputfield.setEditable(false);

		frame.add(inputlabel);
		frame.add(inputfield);
		frame.add(rbutton);
		frame.add(outputlabel);
		frame.add(outputfield);
		
		rbutton.addActionListener(e->{
			int num=Integer.parseInt(inputfield.getText());
			int rev=0;
			
			while(num!=0){
				int dig=num%10;
				rev=rev*10+dig;
				num=num/10;
}
			 outputfield.setText(String.valueOf(rev));

});
			frame.setVisible(true);
	}
}