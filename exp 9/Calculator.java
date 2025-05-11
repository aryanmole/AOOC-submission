import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator{
	public static void main(String[] args){
	
	JFrame frame=new JFrame("Counter");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300,100);
	frame.setLayout(new FlowLayout());

	JLabel inputlabel=new JLabel("Enter two number");
	JTextField a=new JTextField(10);
	JTextField b=new JTextField(10);

	JButton add=new JButton("Addition");
	JButton sub=new JButton("Substraction");
	JButton mul=new JButton("Multiplication");
	JButton div=new JButton("Division");
	JButton rem=new JButton("Remainder");
	JButton sq=new JButton("Square");
	JButton cube=new JButton("Cube");
	
	JLabel outlabel=new JLabel("Answer is");
	JTextField outfield=new JTextField(10);
	outfield.setEditable(false);

	frame.add(inputlabel);
	frame.add(a);
	frame.add(b);
	frame.add(add);
	frame.add(sub);
	frame.add(mul);
	frame.add(div);
	frame.add(rem);
	frame.add(sq);
	frame.add(cube);
	frame.add(outlabel);
	frame.add(outfield);


add.addActionListener(e->{
	int sum = Integer.parseInt(a.getText()) + Integer.parseInt(b.getText());
	outfield.setText(String.valueOf(sum));
});
sub.addActionListener(e->{
	int sum = Integer.parseInt(a.getText()) - Integer.parseInt(b.getText());
outfield.setText(String.valueOf(sum));

});
mul.addActionListener(e->{
	int sum = Integer.parseInt(a.getText()) * Integer.parseInt(b.getText());
	outfield.setText(String.valueOf(sum));
});
div.addActionListener(e->{
	int sum = Integer.parseInt(a.getText()) / Integer.parseInt(b.getText());
	outfield.setText(String.valueOf(sum));

});	
rem.addActionListener(e->{
	int sum = Integer.parseInt(a.getText()) % Integer.parseInt(b.getText());
	outfield.setText(String.valueOf(sum));

});
sq.addActionListener(e->{
	int sum = Integer.parseInt(a.getText()) * Integer.parseInt(a.getText());
outfield.setText(String.valueOf(sum));

});
cube.addActionListener(e->{
	int val = Integer.parseInt(a.getText());
int cub = val * val * val;
outfield.setText(String.valueOf(cub));


});
	frame.setVisible(true);
   }
}