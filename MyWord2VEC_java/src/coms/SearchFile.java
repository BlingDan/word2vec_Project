package coms;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SearchFile extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) throws Exception {
		new SearchFile();
	}
	public SearchFile() {
		JFrame frame = new JFrame("文件查找器");
		frame.setVisible(true);
		frame.setBackground(new Color(66,66,66));
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setResizable(true);
		
		/*frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
		
		JPanel panel = new JPanel(null);
		panel.setBounds(0,0,500,200);
		JButton button1 = new JButton("浏览");
		button1.setBounds(400,50,80,20);
		JButton button2 = new JButton("查找");
		button2.setBounds(400,100,80,20);
		JLabel label1 = new JLabel("选择文件夹位置:");
		label1.setBounds(10,50,120,20);
		JLabel label2 = new JLabel("请输入文件名称:");
		label2.setBounds(10,100,120,20);
		JTextField textfield1 = new JTextField();
		textfield1.setBounds(180,50,150,20);
		JTextField textfield2 = new JTextField();
		textfield2.setBounds(180,100,150,20);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(textfield1);
		panel.add(textfield2);
		panel.add(button1);
		panel.add(button2);
		frame.setContentPane(panel);

		JList list = new JList();
		list.setVisibleRowCount(5);
		list.setBounds(10,200,400,200);
		JScrollPane jsp=new JScrollPane(list,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(10,200,417,218);
		frame.add(list);
		frame.add(jsp);

		button1.addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc=new JFileChooser();
	    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
	    jfc.showDialog(new JLabel(), "打开");
	    File file=jfc.getSelectedFile();
	    //打印和导入文件;
	    File file2 = new File("./temp");
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(file2.getAbsoluteFile());
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
	    String st;
	    try {
			while((st = br.readLine()) != null) {
				System.out.println(st);
				bw.write(st);
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}//
	    try {
			bw.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    
    	if(file.isDirectory()){
	    	System.out.println(file.getAbsolutePath());
	    }else if(file.isFile()){
	    	System.out.println(file.getAbsolutePath());
	    }
	    System.out.println(jfc.getSelectedFile().getName());
	    int option = jfc.showOpenDialog(null);
	    if(option == JFileChooser.APPROVE_OPTION)
	    {
	    File file1 = jfc.getSelectedFile();
	    try {
			FileReader reader = new FileReader(file1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    }
	    }	
}