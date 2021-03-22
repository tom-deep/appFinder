import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class addMenu extends JFrame {
	JPanel panel;
	JTextField appName;
	JButton submit;
	
	addMenu(){
		panel = new JPanel(new GridLayout(3, 1));
		appName = new JTextField("Enter App Name");
		submit = new JButton("Add");
		panel.add(appName);
		panel.add(submit);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel, BorderLayout.CENTER);
	    setTitle("Add App");
	    setSize(450,350);
	    setVisible(true);
	}
}
