import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class mainMenu extends JFrame implements ActionListener {
	JPanel panel;
	JLabel label;
	JTextField search;
	JButton submit, addApp;
	
	mainMenu(){
		panel = new JPanel(new GridLayout(4, 1));
		search = new JTextField("Enter App Name");
		label = new JLabel();
		submit = new JButton("Find App");
		addApp = new JButton("Add App");
		panel.add(search);
		panel.add(label);
		panel.add(submit);
		panel.add(addApp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addApp.addActionListener(this);
		
		add(panel, BorderLayout.CENTER);
	    setTitle("Main Menu");
	    setSize(450,350);
	    setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new addMenu();
	}
	
}
