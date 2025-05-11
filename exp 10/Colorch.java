import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Colorch extends JFrame implements ActionListener{

	JButton b1,b2,b3;
  public Colorch(){
	
	setSize(300,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());

	b1=new JButton("ORANGE");
	b2=new JButton("YELLOW");
	b3=new JButton("RED");

	b1.setBounds(30,100,80,30);
	b2.setBounds(30,130,80,30);
	b3.setBounds(30,230,80,30);

	add(b1);
	add(b2);
	add(b3);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);

	setVisible(true);
 }
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			getContentPane().setBackground(Color.ORANGE);
  }
		if(e.getSource()==b2){
			getContentPane().setBackground(Color.YELLOW);
  }
		if(e.getSource()==b3){
			getContentPane().setBackground(Color.RED);
  }

 }
	public static void main(String[] args){
		new Colorch();
  }	
}