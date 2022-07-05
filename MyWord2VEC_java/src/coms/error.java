package coms;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class error {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label = new JLabel("请输入关键词!");
	JButton button = new JButton("确定");
	JFrame jf = new JFrame("Error!");
	
	public static void main(String[] args) {
		new error();
	}
	
	public error() {
		jf.setBounds(600,400,300,150);//300,150
		jf.setVisible(true);
		jf.setLayout(new GridLayout(2,1));
		
		label.setBounds(100,50,100,50);
		button.setBounds(100,100,100,50);
		button.setContentAreaFilled(false);
		jf.add(label);
		jf.add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.dispose();
			}
		});
	}
}
