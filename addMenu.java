import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.event.*;
import javax.swing.*;
public class addMenu extends JFrame implements ActionListener, Serializable {
	JPanel panel;
	JTextField appName, appDeveloper;
	JButton submit;
	String appN, appD;
	
	addMenu(){
		panel = new JPanel(new GridLayout(3, 1));
		appName = new JTextField("Enter App Name");
		appDeveloper = new JTextField("Enter App Developer");
		submit = new JButton("Add");
		panel.add(appName);
		panel.add(appDeveloper);
		panel.add(submit);
		submit.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel, BorderLayout.CENTER);
	    setTitle("Add App");
	    setSize(450,350);
	    setVisible(true);
	}
	
	public void writeObject(app a) {
		String fileName = "appData.txt";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(a);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		appN = appName.getText();
		appD = appDeveloper.getText();
		app nApp = new app(appN, appD);
		writeObject(nApp);
		setVisible(false);
	}
	
	
}
