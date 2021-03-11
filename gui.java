package appFinder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gui implements ActionListener {
	private int count = 0;
	private JFrame frame;
	private JLabel appCount;
	private JPanel panel;
	
	
	public gui() {
		
		frame = new JFrame();
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(this);
		
		appCount = new JLabel("Apps added: 0");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(addButton);
		panel.add(appCount);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("appFinder");
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new gui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		count++;
		appCount.setText("Apps added: " + count);
		
	}
}
