import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
public class mainMenu extends JFrame implements ActionListener {
	JPanel panel;
	JLabel label, message;
	JTextField search;
	JButton submit, addApp;
	
	mainMenu(){
		panel = new JPanel(new GridLayout(5, 1));
		search = new JTextField("Enter App Name");
		label = new JLabel();
		submit = new JButton("Find App");
		addApp = new JButton("Add App");
		panel.add(search);
		panel.add(label);
		panel.add(submit);
		panel.add(addApp);
		message = new JLabel();
		panel.add(message);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addApp.addActionListener(this);
		
		add(panel, BorderLayout.CENTER);
	    setTitle("Main Menu");
	    setSize(450,350);
	    setVisible(true);
	}
	
	public app readObjectFromFile(String fName) {
		try {			 
            FileInputStream fileIn = new FileInputStream(fName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            objectIn.close();
            return (app) obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new addMenu();
		message.setText("App successfully added");
		app tempApp = readObjectFromFile("appData.txt");
		label.setText(tempApp.toString());
	}
	
}
